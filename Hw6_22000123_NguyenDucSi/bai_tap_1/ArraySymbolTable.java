package DSA.Hw6_22000123_NguyenDucSi.bai_tap_1;

import java.util.Iterator;

public class ArraySymbolTable <Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    int size;
    final int DEFAULT_CAPACITY = 100;

    public ArraySymbolTable() {
        keys = (Key[]) new Comparable[DEFAULT_CAPACITY];
        values = (Value[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void put(Key key, Value value) {
        for(int i = 0; i < size; ++i) {
            if(key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        if(size == keys.length) {
            resize(2 * keys.length);
        }

        keys[size] = key;
        values[size] = value;
        ++size;
    }

    @Override
    public Value get(Key key) {
        for(int i = 0; i < size; ++i) {
            if(key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        return new Iterable<>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<>() {
                    int index = 0;

                    @Override
                    public boolean hasNext() {
                        return index < size;
                    }

                    @Override
                    public Key next() {
                        return keys[index++];
                    }
                };
            }
        };
    }


    @Override
    public boolean contains(Key key) {
        for(int i = 0; i < size; ++i) {
            if(key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(Key key) {
        int id = 0;
        for(int i = 0; i < size; ++i) {
            if(key.equals(keys[i])) {
                id = i;
                break;
            }
        }
        for(int i = id; i < size - 1; ++i) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        --size;
    }

    private void resize(int capacity) {
        Key[] tempKeys = (Key[]) new Comparable[capacity];
        Value[] tempValues = (Value[]) new Object[capacity];
        for(int i = 0; i < size; ++i) {
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }
        keys = tempKeys;
        values = tempValues;
    }
}
