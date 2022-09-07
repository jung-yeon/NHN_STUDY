public interface Queue<E> {
    boolean isEmpty();
    void add(E element);
    E element();
    E remove();
    int size();
}
