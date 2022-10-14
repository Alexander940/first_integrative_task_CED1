package model;

public class Queue<T> {

    Node head, tail;
    int size;

    public Queue() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void enqueue(T fact){
        Node node = new Node<>(fact);

        if(!isEmpty()){
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    public T dequeue(){
        T aux = (T) head.fact;
        head = head.next;
        size--;
        return aux;
    }

    public T front(){
        return (T) head.fact;
    }

    public int size(){
        return size;
    }
}
