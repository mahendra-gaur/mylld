package org.example.policies;

import org.example.exception.EvictionException;
import org.example.model.KeyNode;
import org.example.repository.DataStore;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.example.Utility.TimeUtils.getCurrentTimeStamp;

public class TtlEvictionPolicy<Key, Value> implements EvictionPolicy<Key>{

    private final DataStore<Key, Value> dataStore;
    private final PriorityQueue<KeyNode<Key>> queue;
    private final int evictionPeriod = 1000;
    public TtlEvictionPolicy(DataStore<Key, Value> dataStore){
        queue = new PriorityQueue<>(new Comparator<KeyNode<Key>>() {
            @Override
            public int compare(KeyNode<Key> o1, KeyNode<Key> o2) {
                return (int) o1.getTimeStamp() - (int) o2.getTimeStamp();
            }
        });
        this.dataStore = dataStore;
    }
    @Override
    public void keyAdded(Key key, long timeStamp) {
        queue.add(new KeyNode<>(key, timeStamp));
    }

    @Override
    public void runEvictionStrategy(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (queue) {
                        evictData();
                        try {
                            Thread.sleep(evictionPeriod);
                        } catch (InterruptedException e) {
                            throw new EvictionException(e.getMessage());
                        }
                    }
                }
            }
        }).start();
    }

    private void evictData() {
        while(!queue.isEmpty() && queue.peek().getTimeStamp()<= getCurrentTimeStamp()){
            KeyNode<Key> keyNode = queue.poll();
            dataStore.removeData(keyNode.getKey());

        }
    }
}
