package DSA.Hw4_22000123_NguyenDucSi.baitap2;

public interface StackInterface<E> extends Iterable<E> {
    public void push ( E element ) ;
    public E pop () ;
    public boolean isEmpty () ;
    public E top () ;

}
