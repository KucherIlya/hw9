package goit.homeworks;


public class Main {

    public static void main(String[] args){

        MyList<String> myList = new MyArrayList<>();
        myList.add("my list element");
        myList.add("my list element two");
        System.err.println("MyList first element added: " + myList.get(0));
        System.err.println("MyList second element added: " + myList.get(1));
        System.err.println("MyList size after add() 2 elements: " + myList.size());
        System.err.println("Removing first element");
        myList.remove(0);
        System.err.println("MyList size after remove() the first element: " + myList.size());
        System.err.println("Clearing myList");
        myList.clear();
        System.err.println("MyList size after clear(): " + myList.size());


        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("my linked list element");
        myLinkedList.add("my linked list element two");
        System.err.println("MyLinkedList first element added: " + myLinkedList.get(0));
        System.err.println("MyLinkedList second element added: " + myLinkedList.get(1));
        System.err.println("MyLinkedList size after add() 2 elements: " + myLinkedList.size());
        System.err.println("Removing first element");
        myLinkedList.remove(0);
        System.err.println("MyLinkedList size after remove() the first element: " + myLinkedList.size());
        System.err.println("Clearing myLinkedList");
        myLinkedList.clear();
        System.err.println("MyLinkedList size after clear(): " + myLinkedList.size());


        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("my queue element");
        myQueue.add("my queue element two");
        System.err.println("MyQueue size after two elements added: " + myQueue.size());
        System.err.println("MyQueue first element added: " + myQueue.peek());
        System.err.println("MyQueue first element removed and returned: " + myQueue.poll());
        System.err.println("MyQueue size after poll() of the first element: " + myQueue.size());
        System.err.println("Clearing MyQueue");
        myQueue.clear();
        System.err.println("MyQueue size after clear(): " + myQueue.size());


        MyStack<String> myStack = new MyStack<>();
        myStack.add("my queue element");
        myStack.add("my queue element two");
        System.err.println("MyStack size after two elements added: " + myStack.size());
        System.err.println("MyStack first element added: " + myStack.peek());
        System.err.println("MyStack first element removed and returned: " + myStack.pop());
        System.err.println("MyStack size after pop() of the first element: " + myStack.size());
        System.err.println("Clearing MyStack");
        myStack.clear();
        System.err.println("MyStack size after clear(): " + myStack.size());


        MyHashMap<String, Integer> myMap = new MyHashMap<>();
        myMap.put("my map key", 1);
        myMap.put("my map key two", 2);
        System.err.println("MyHashMap size after two elements added: " + myMap.size());
        System.err.println("MyHashMap element with key 'my map key': " + myMap.get("my map key").toString());
        System.err.println("MyHashMap element with key 'my map key' removing");
        myMap.remove("my map key");
        System.err.println("MyHashMap size after remove() of the element with key 'my map key': " + myMap.size());
        System.err.println("Clearing MyHashMap");
        myMap.clear();
        System.err.println("MyHashMap size after clear(): " + myMap.size());
    }

}
