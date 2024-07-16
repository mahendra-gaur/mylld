package org.example.model;

public class ValueNode<Value> {
    Value value;
    long timeStamp;

    public ValueNode(Value value, long timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }

    public Value getValue() {
        return value;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
