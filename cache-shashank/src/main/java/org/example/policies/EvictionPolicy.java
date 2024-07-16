package org.example.policies;

public interface EvictionPolicy<Key> {

    void keyAdded(Key key, long timeStamp);

    void runEvictionStrategy();
}
