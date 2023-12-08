package goit.homeworks;

import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyDeque<T>, MyList<T> {

    // Amount of elements in chain (linked objects in MyLinkedList)
    private int size;

    // The first element link of the MyLinkedList
    private MyNode<T> firstLink;

    // The last element link of the MyLinkedList
    private MyNode<T> lastLink;

    /**
    This field keep information about any changes in the current MyLinkedList object to prevent Exception to using object during
    any changes and addressing to changing element.
     */
    private transient int modificationsCounter = 0;

    /**
    Get the first link element. If there is no such element, throws a RuntimeException
     */
    private T getFirstLink() {
        MyNode<T> f = firstLink;
        try {
            return f.current;
        } catch (NoSuchElementException NO) {
            throw new RuntimeException("Exception message: " + NO, NO);
        }
    }

    /**
    Get the last link element. If there is no such element, throws a RuntimeException
     */
    private T getLastLink() {
        MyNode<T> l = lastLink;
        try {
            return l.current;
        } catch (NoSuchElementException NO) {
            throw new RuntimeException("Exception message: " + NO, NO);
        }
    }

    /**
    Get the element that is placed on @param 'i' place in MyLinkedList
     */
    @Override
    public T get(int i) {
        return getNode(i).current;
    }

    /**
    Add @param E element into the chain of links MyLinkedList on the last place.
     */
    @Override
    public void add(T o) {
        linkLast(o);
    }

    /**
    Add @param E element into the chain of links MyLinkedList on the first place.
     */
    public void addFirst(T o) {
        linkFirst(o);
    }

    /**
    Add @param E element into the chain of links MyLinkedList on the last place.
     */
    public void addLast(T E) {
        linkLast(E);
    }

    /**
    Element that is placed on @param 'i' place in MyLinkedList gets new value of 'current' field that is equal to @param E
     */
    @Override
    public boolean set(int i, T o) {
        try {
            checkIndexElement(i);
            MyNode<T> r = getNode(i);
            r.current = o;
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeByValue(T E) {
        MyNode<T> c = firstLink;

        for (int k = 0; k < size; k++) {
            if (c.current.equals(E)) {
                excludeNode(c);
                return true;
            }
            if (c.nextLink == null) break;
            c = c.nextLink;
        }

        return false;
    }

    /**
    Removes an element from MyLinkedList that is placed on @param 'i' place
     */
    @Override
    public boolean remove(int i) {
        try {
            checkIndexElement(i);
            excludeNode(getNode(i));
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T delete(int i) {
        checkIndexElement(i);
        return excludeNode(getNode(i));
    }

    /**
    Returns 'size' field of MyLinkedList
     */
    @Override
    public int size() {
        return size;
    }

    /**
    Returns true if 'size' field of MyLinkedList is equal to 0
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
    Returns true if MyLinkedList includes an element that is equal to @param E
     */
    @Override
    public boolean contains(T E) {
        MyNode<T> c = firstLink;

        for (int k = 0; k < size; k++) {
            if (c.current.equals(E)) return true;
            if (c.nextLink == null) break;
            c = c.nextLink;
        }
        return false;
    }

    /**
    Sets null value for each field of elements in MyLinkedList
     */
    @Override
    public void clear() {

        MyNode<T> c = firstLink;

        for (int k = 0; k < size; k++) {
            if(c != null){
                MyNode<T> n = c.nextLink;
                if (n != null) c.nextLink = null;
                if (n != null) c.prevLink = null;
                c.current = null;
                c = n;
            }
        }

        firstLink = null;
        lastLink = null;
        size = 0;
        modificationsCounter++;
    }

    /**
    Removes the first element and returns this removed element. If there is no such element, returns null
     */
    @Override
    public T poll() {
        final MyNode<T> f = firstLink;
        return (f == null) ? null : delete(0);
    }

    /**
    Returns the first element. If there is no such element, returns null
     */
    @Override
    public T peek() {
        final MyNode<T> f = firstLink;
        return (f == null) ? null : f.current;
    }

    /**
    Sets null for each field of @param 'N' element in MyLinkedList and change the prevLink and nextLink fields for
    next element after @param 'N' and previous element before @param 'N' accordingly
     */
    private T excludeNode(MyNode<T> N) {

        final MyNode<T> p = N.prevLink;
        final MyNode<T> n = N.nextLink;

        if(p == null){
            if(n == null){
                N.current = null;
            }else{
                firstLink = n;
                firstLink.prevLink = null;
            }
        }else if(n == null){
            lastLink = p;
            lastLink.nextLink = null;
        }else{
            p.nextLink = n;
            n.prevLink = p;
        }

        size--;
        modificationsCounter++;

        return N.current;
    }

    /**
    Creates new element equals to @param E in MyLinkedList before @param 'N' element.
    Changes the nextLink and prevLink fields for elements after previous element before @param 'N' element and next
    element after @param 'N' accordingly
     */
    private void insertBefore(T E, MyNode<T> N) {

        final MyNode<T> iNode = new MyNode<>(N.prevLink, E, N);
        N.prevLink = iNode;

        if (iNode.prevLink == null) {
            firstLink = iNode;
        } else {
            iNode.prevLink.nextLink = iNode;
        }

        size++;
        modificationsCounter++;

    }

    /**
    Sets firstLink field as a @param E.
     */
    private void linkFirst(T E) {

        final MyNode<T> i = firstLink;
        final MyNode<T> iNode = new MyNode<>(null, E, i);

        firstLink = iNode;
        if (i == null) {
            lastLink = iNode;
        } else {
            i.prevLink = iNode;
        }
        size++;
        modificationsCounter++;
    }

    /**
    Sets lastLink field as a @param E.
     */
    private void linkLast(T E) {

        final MyNode<T> i = lastLink;
        final MyNode<T> iNode = new MyNode<>(i, E, null);

        lastLink = iNode;
        if (i == null) {
            firstLink = iNode;
        } else {
            i.nextLink = iNode;
        }
        size++;
        modificationsCounter++;

    }

    /**
    Returns Node element that is placed on @param 'i' place in MyLinkedList
     */
    private MyNode<T> getNode(int i) {

        MyNode<T> c;
        if (i < (size / 2)) {
            c = firstLink;
            for (int k = 0; k < i; k++) {
                if (c.nextLink == null) break;
                c = c.nextLink;
            }
        } else {
            c = lastLink;
            for (int k = 0; k < size - i - 1; k++) {
                if (c.prevLink == null) break;
                c = c.prevLink;
            }
        }
        return c;

    }

    /**
    Check if @param 'i' is not negative and less than size field value. In case of false, throws an Exception
    */
    private void checkIndexElement(int i) {
        if (i >= size || i < 0)
            throw new IndexOutOfBoundsException("Index " + i + " is out of range");
    }


    @Override
    public String toString() {

        if(size == 0) return "[]";

        StringBuilder a = new StringBuilder();
        a.append("[");
        MyNode<T> m = firstLink;
        int k = 0;

        while (k < size) {
            k++;
            a.append(m.current.toString());
            if (m.nextLink != null) {
                m = m.nextLink;
                a.append(", ");
            } else {
                a.append("]");
                break;
            }
        }

        return a.toString();
    }


    /**
    MyNode class. It's objects represent an elements of MyLinkedList
     */
    private static class MyNode<T> {

        protected T current;

        protected MyNode<T> prevLink;

        protected MyNode<T> nextLink;

        public MyNode(MyNode<T> prevLink, T current, MyNode<T> nextLink) {
            this.current = current;
            this.prevLink = prevLink;
            this.nextLink = nextLink;
        }
    }
}