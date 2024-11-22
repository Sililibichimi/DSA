package DSA.Hw6_22000123_NguyenDucSi.bai_tap_5;

public class MyHashSet {

    int[] set;
    int size;
    final int DEFAULT_CAPACITY = 16;

    public MyHashSet() {
        set = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(int key) {
        for (int i = 0; i < size; i++) {
            if (set[i] == key) {
                return;
            }
        }
        if (size == set.length) {
            enlarge();
        }
        set[size] = key;
        ++size;
    }

    private void enlarge() {
        int[] newSet = new int[set.length * 2];
        for (int i = 0; i < size; i++) {
            newSet[i] = set[i];
        }
        set = newSet;
    }

    public void remove(int key) {
        for (int i = 0; i < size; i++) {
            if (set[i] == key) {
                for (int j = i; j < size - 1; j++) {
                    set[j] = set[j + 1];
                }
                --size;
                return;
            }
        }
    }

    public boolean contains(int key) {
        for (int i = 0; i < size; i++) {
            if (set[i] == key) {
                return true;
            }
        }
        return false;
    }
}
