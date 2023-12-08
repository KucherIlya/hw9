package goit.homeworks;

import java.util.Arrays;

public class MyStack<T> implements MyCollection<T>, MyFifoCollection<T> {

    private Object [] array;

    private int size;

    public MyStack() {
        this.array = new Object[0];
        this.size = 0;
    }

    public MyStack(T[] array) {
        this.size = array.length;
        this.array = array;
    }

    public MyStack(MyList<T> list) {
        this.size = list.size();
        this.array = new Object[size-1];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
    }

    @Override
    public void add(T E) {
        var a = new Object[array.length + 1];
        System.arraycopy(array, 0, a, 0, a.length - 1);
        a[a.length - 1] = E;
        setArray(a);
        size++;
    }

    public void push(T E) {
        add(E);
    }

    private void setArray(Object[] a) {
        this.array = a;
    }

    @Override
    public void clear() {
        setArray(new Object[0]);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        try {
            return (T) array[0];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T poll() {
        try {
            T a = (T) array[0];
            array = Arrays.copyOfRange(array, 1, array.length);
            size--;
            return a;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public T pop() {
        return poll();
    }

    @Override
    public boolean remove(int i) {
        try {
            var a = new Object[array.length - 1];
            System.arraycopy(array, 0, a, 0, i);
            System.arraycopy(array, i + 1, a, i, array.length - ( i + 1 ));
            setArray(a);
            size--;
            return true;
        } catch (Exception e) {
            throw new RuntimeException("There is no index " + i + " in array", e);
        }
    }
}
