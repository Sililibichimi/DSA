package DSA.Hw4_22000123_NguyenDucSi.baitap4;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();

}
