package org.example.repository;

import org.example.exception.StorageFullException;
import org.example.model.ValueNode;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedDataStore<Key, Value> implements DataStore<Key, Value>{

    private final int capacity;
    private final Map<Key, ValueNode<Value>> mapper;

    public HashMapBasedDataStore(int capacity){
        this.capacity = capacity;
        this.mapper = new HashMap<>();
    }

    @Override
    public void addData(Key key, Value value, long timeStamp) {
        if(mapper.size()>=capacity){
            throw new StorageFullException("Storage is full");
        }
        mapper.put(key, new ValueNode<Value>(value, timeStamp));
    }

    @Override
    public ValueNode<Value> getData(Key key) {
        return mapper.get(key);
    }

    @Override
    public void removeData(Key key) {
        System.out.println("Data being Removed---> "+ key.toString());
        mapper.remove(key);
    }
}
