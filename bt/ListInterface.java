package DSA.bt;

public interface ListInterface<T> extends Iterable {
    void add(T add);
    T get(int i);
    void set (int i , T data ) ;
    void remove ( T data ) ;
    boolean isContain ( T data ) ;
    int size () ;
    boolean isEmpty () ;

}
