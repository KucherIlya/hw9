package goit.homeworks;

public interface MyList<T> extends MyCollection<T> {

    boolean set(int i, T E);

    boolean removeByValue(T E);

    T get(int i);

}
