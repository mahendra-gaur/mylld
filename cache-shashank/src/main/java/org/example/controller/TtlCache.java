package org.example.controller;

import org.example.model.ValueNode;
import org.example.policies.TtlEvictionPolicy;
import org.example.repository.DataStore;
import org.example.repository.HashMapBasedDataStore;

import java.util.Objects;

import static org.example.Utility.TimeUtils.getCurrentTimeStamp;
import static org.example.Utility.TimeUtils.getFutureTime;

public class TtlCache<Key, Value> implements ICache<Key, Value>{
    private DataStore<Key, Value> dataStore;
    private final int capacity;

    private TtlEvictionPolicy<Key, Value> tTlEvictionPolicy;

    public  TtlCache(int capacity){
        this.capacity = capacity;
        initialize();
    }

    @Override
    public void initialize() {
        dataStore = new HashMapBasedDataStore<>(capacity);
        tTlEvictionPolicy = new TtlEvictionPolicy<>(dataStore);
        tTlEvictionPolicy.runEvictionStrategy();
    }

    @Override
    public void put(Key key, Value value) {
        dataStore.addData(key, value, getFutureTime());
        tTlEvictionPolicy.keyAdded(key,  getFutureTime());
    }

    @Override
    public void put(Key key, Value value, long timeInMilliSeconds) {
        dataStore.addData(key, value, getCurrentTimeStamp() + timeInMilliSeconds);
        tTlEvictionPolicy.keyAdded(key,  getCurrentTimeStamp() + timeInMilliSeconds);
    }

    @Override
    public Value get(Key key) {
        ValueNode<Value> valueNode = dataStore.getData(key);
        if(Objects.nonNull(valueNode) && valueNode.getTimeStamp() >= getCurrentTimeStamp()){
            return valueNode.getValue();
        }
        return null;
    }
}
