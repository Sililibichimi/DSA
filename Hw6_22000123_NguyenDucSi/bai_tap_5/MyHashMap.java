package DSA.Hw6_22000123_NguyenDucSi.bai_tap_5;

public class MyHashMap {

    int[] keys;
    int[] values;
    int size;
    final int DEFAULT_CAPACITY = 16;

    public MyHashMap() {
        keys = new int[DEFAULT_CAPACITY];
        values = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(int key, int value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            enlarge();
        }
        keys[size] = key;
        values[size] = value;
        ++size;
    }

    public int get(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return values[i];
            }
        }
        System.out.println("Key not found");
        return -1;
    }

    public void remove(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                for (int j = i; j < size - 1; j++) {
                    keys[j] = keys[j + 1];
                    values[j] = values[j + 1];
                }
                --size;
                return;
            }
        }
        System.out.println("Key not found");
    }

    public void enlarge() {
        int[] newKeys = new int[keys.length * 2];
        int[] newValues = new int[values.length * 2];
        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }
}
