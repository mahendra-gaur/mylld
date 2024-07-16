package org.example.repository;

import org.example.model.ValueNode;

public interface DataStore <Key, Value>{
    void addData(Key key, Value value, long timeStamp);

    ValueNode<Value> getData(Key key);

    void removeData(Key key);
}
