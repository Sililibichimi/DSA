package DSA.Hw3_22000123_NguyenDucSi.bai2;

public interface ListInterface<T> extends Iterable {
    void add(T add);
    T get(int i);
    int indexOf(T data);
    void set (int i , T data ) ;
    void remove ( T data ) ;
    boolean isContain ( T data ) ;
    int size () ;
    boolean isEmpty () ;
    boolean checkBoundaries(int k);
}
