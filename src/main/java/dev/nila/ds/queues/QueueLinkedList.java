package dev.nila.ds.queues;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class QueueLinkedList {

    Node head = null;

    void enqueue(int data){
        Node newNode = new Node(data);
        Node temp = null;
        if(head != null){
            temp = head;
        }
        head = newNode;
        head.next = temp;
    }

    int dequeue(){
        if(head == null){
            System.out.println("Queue is empty");
            return -1;
        }
        Node temp = head;
        head = temp.next;
        return temp.data;
    }

    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(1);

        queue.display();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.display();
    }

}
