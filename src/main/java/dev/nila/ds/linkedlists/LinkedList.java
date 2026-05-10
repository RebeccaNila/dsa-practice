package dev.nila.ds.linkedlists;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    private Node head;

    public LinkedList(){
        head = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void insertAtIndex(int index, int data) {
        if (index < 0) return;

        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) return;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteByValue(int key) {
        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) return;

        if (index == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) return;

        temp.next = temp.next.next;
    }

    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }
    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtIndex(1, 15);
        list.insertAtEnd(30);
        list.display(); // 10 -> 15 -> 20 -> null

        list.reverse();
        list.display();

        list.deleteByValue(15);
        list.display(); // 10 -> 20 -> null

        list.deleteAtIndex(0);
        list.display(); // 20 -> null

        System.out.println("Search 20: " + list.search(20)); // true
        System.out.println("Search 10: " + list.search(10)); // false
    }

    /**
     * Operation	            Time Complexity
     * Access	                O(n)
     * Search	                O(n)
     * Insert at Beginning	    O(1)
     * Insert at End / Index	O(n)
     * Delete	                O(n)
     */





}
