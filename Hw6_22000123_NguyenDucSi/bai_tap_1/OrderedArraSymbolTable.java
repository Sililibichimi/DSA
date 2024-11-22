package DSA.Hw6_22000123_NguyenDucSi.bai_tap_1;

import java.util.Iterator;

public class OrderedArraSymbolTable <Key extends Comparable<Key>, Value>  implements OrderedSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    int size;
    final int DEFAULT_CAPACITY = 100;

    public OrderedArraSymbolTable() {
        keys = (Key[]) new Comparable[DEFAULT_CAPACITY];
        values = (Value[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void put(Key key, Value value) {

        int i = 0;
        for(i = 0; i < size; ++i) {
            if(keys[i].compareTo(key) >= 0) {
                break;
            }
        }
        if (keys[i].equals(key)) {
            values[i] = value;
            return;
        }
        if(size == keys.length) {
            resize(2 * keys.length);
        }

        for(int j = size; j > i; --j) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        ++size;
    }

    private void resize(int i) {
        Key[] newKeys = (Key[]) new Comparable[i];
        Value[] newValues = (Value[]) new Object[i];
        for(int j = 0; j < size; ++j) {
            newKeys[j] = keys[j];
            newValues[j] = values[j];
        }
        keys = newKeys;
        values = newValues;
    }

    @Override
    public Value get(Key key) {
        int i = getIndex(key);
        if(i == -1) {
            return null;
        }
        return values[i];
    }

    public int getIndex(Key key) {
        int lo = 0;
        int hi = size - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) {
                hi = mid - 1;
            } else if(cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Override
    public void delete(Key key) {
        int idex = getIndex(key);
        if(idex == -1) {
            return;
        }
        for(int i = idex; i < size - 1; ++i) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        --size;
    }

    @Override
    public boolean contains(Key key) {
        return getIndex(key) != -1;
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
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
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
    public Key min() {
        if(size == 0) {
            return null;
        }
        return keys[0];
    }

    @Override
    public Key max() {
        if(size == 0) {
            return null;
        }
        return keys[size - 1];
    }

    @Override
    public Key floor(Key key) {
        int lo = 0;
        int hi = size - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            int cmp = keys[mid].compareTo(key);

            if(cmp > 0) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        if(keys[lo].compareTo(key) <= 0) {
            return keys[lo];
        }
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        int lo = 0;
        int hi = size - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = keys[mid].compareTo(key);

            if(cmp < 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if(keys[lo].compareTo(key) >= 0) {
            return keys[lo];
        }
        return null;
    }

    @Override
    public int rank(Key key) {
        return getIndex(key);
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public void deleteMin() {
        for(int i = 0; i < size - 1; ++i) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        --size;
    }

    @Override
    public void deleteMax() {
        --size;
    }

    @Override
    public int size(Key lo, Key hi) {
        if(lo.compareTo(hi) >= 0) {
            return 0;
        }
        int l = getIndex(lo);
        int r = getIndex(hi);
        if(l == -1 || r == -1) {
            return 0;
        }
        return r - l + 1;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    int index = getIndex(lo);
                    @Override
                    public boolean hasNext() {
                        return index < size && keys[index].compareTo(hi) <= 0;
                    }

                    @Override
                    public Key next() {
                        return keys[index++];
                    }
                };
            }
        };
    }
}
