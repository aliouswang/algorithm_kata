package spring_2;

public class LinkListStack<T> implements IStack<T>{

    private class Node {
        T data;
        Node next;

        public Node(T t) {
            this.data = t;
        }
    }

    private int size;
    private Node head;

    public LinkListStack() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void push(T t) {
        Node newNode = new Node(t);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T t = head.data;
        head = head.next;
        return t;
    }
}
