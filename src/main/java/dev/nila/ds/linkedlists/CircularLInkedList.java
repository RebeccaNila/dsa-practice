package dev.nila.ds.linkedlists;

public class CircularLInkedList <T> {

    class Node {
        T data;
        Node next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    Node tail;
    CircularLInkedList(){
        tail = null;
    }

    void insertAtBeginning(T data){
        Node newNode = new Node(data);
        //if tail is null the LL is empty
        //if LL is null then newNode address will be itself address self looping
        if(tail == null){
            newNode.next = newNode;
            tail = newNode;
        }else{
            //tail next will route to head, so newNode will route to head
            newNode.next = tail.next;
            //current tail will route to newNode
            tail.next = newNode;
        }
    }

    void insertAtLast(T data){
        Node newNode = new Node(data);
        //if tail is null the LL is empty
        //if LL is null then newNode address will be itself address self looping
        if(tail == null){
            newNode.next = newNode;
            tail = newNode;
        }else{
            //tail next will route to head, so newNode will route to head
            newNode.next = tail.next;
            //current tail will route to newNode
            tail.next = newNode;
            tail = newNode;
        }
    }

    void display(){
        Node temp = tail;
        System.out.println();
        //to run one time so use do while loop
        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }while(temp != tail);// to avoid infinite loop
//        System.out.println(tail.data);
    }

    void deleteAtBeginning(){
        if(tail == null){
            System.out.println("Empty List");
            return;
        }
        if(tail.next == tail){
            tail = null;
            return;
        }else{
            tail.next = tail.next.next;
        }
    }

    void deleteAtLast(){
        if(tail == null){
            System.out.println("Empty List");
            return;
        }
        if(tail.next == tail){
            tail = null;
            return;
        }else{
           Node temp = tail;
           while(temp.next != tail){
               temp = temp.next;
           }
           //temp.next.next or tail.next
           temp.next = tail.next;
           tail = temp;
        }
    }

    public static void main(String[] args) {
        CircularLInkedList<Integer> list = new CircularLInkedList<>();
        list.insertAtBeginning(7);
        list.insertAtBeginning(5);
        list.insertAtBeginning(1);
        list.insertAtLast(8);
        //list.deleteAtBeginning();
        list.deleteAtLast();
        list.display();

    }
}
