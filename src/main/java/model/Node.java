package model;

public class Node<T> {

    T fact;
    Node next;

    public Node(T fact) {
        this.fact = fact;
        next = null;
    }
}
