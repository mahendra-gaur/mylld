package org.example.model;

public class KeyNode<Key> {
    private Key key;

    public KeyNode(Key key, long timeStamp) {
        this.key = key;
        this.timeStamp = timeStamp;
    }

    public Key getKey() {
        return key;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    private long timeStamp;
}
