package goit.homeworks;

public class MyArrayList<T> implements MyList<T> {

    private Object [] array;

    private int size;

    public MyArrayList() {
        this.array = new Object[0];
        this.size = 0;
    }

    public MyArrayList(T[] array) {
        this.size = array.length;
        this.array = array;
    }

    public MyArrayList(MyList<T> list) {
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

    private void setArray(Object[] a) {
        this.array = a;
    }

    @Override
    public boolean set(int i, T E) {
        try {
            array[i] = E;
            return true;
        } catch (Exception e) {
            throw new RuntimeException("There is no index " + i + " in array", e);
        }
    }

    @Override
    public boolean removeByValue(T E) {
        try {
            int k = 0;
            for (Object i : array) {
                if (i.equals(E)) {
                    remove(k);
                    k--;
                }
                k++;
            }
            size--;
            return true;
        } catch (Exception e) {
            return false;
        }
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
    public T get(int i) {
        try {
            return (T) array[i];
        }catch (Exception e){
            throw new RuntimeException("There is no index " + i + " in array", e);
        }
    }
}
