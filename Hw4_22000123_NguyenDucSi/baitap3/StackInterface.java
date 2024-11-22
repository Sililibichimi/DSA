package DSA.Hw4_22000123_NguyenDucSi.baitap3;

public interface StackInterface<E> extends Iterable<E> {
    public void push ( E element ) ;
    public E pop () ;
    public boolean isEmpty () ;
    public E top () ;
    public String print();
}
