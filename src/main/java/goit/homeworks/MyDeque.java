package goit.homeworks;

public interface MyDeque<T> extends MyFifoCollection<T> {

    int size();

    boolean isEmpty();

    boolean contains(T E);

    void add(T E);

    void clear();

    boolean remove(int i);

    T delete(int i);

    void addFirst(T E);

    void addLast(T E);

}
