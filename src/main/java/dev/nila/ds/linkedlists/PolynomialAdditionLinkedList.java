package dev.nila.ds.linkedlists;


public class PolynomialAdditionLinkedList {
    static class Node {
        int coefficient;
        int exponent;
        Node next;

        Node(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null;
        }
    }

    static class LinkedList {

        Node head;

        public LinkedList(){
            head = null;
        }

        public void insertAtBeginning(int coefficient, int exponent) {
            Node newNode = new Node(coefficient, exponent);
            newNode.next = head;
            head = newNode;
        }

        public void insertLast(int coefficient, int exponent) {
            Node newNode = new Node(coefficient, exponent);
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


        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.coefficient+"x^"+ temp.exponent+ " + ");
                temp = temp.next;
            }
            System.out.println("null");
        }

    }

    static LinkedList p = null;
    static void addPoly(Node p1, Node p2){
        p = new LinkedList();
        while(p1 != null && p2 != null){
            if(p1.exponent == p2.exponent){
                p.insertLast(p1.coefficient+p2.coefficient, p2.exponent);
                p1 = p1.next;
                p2 = p2.next;
            }else if(p1.exponent > p2.exponent){
                p.insertLast(p1.coefficient, p1.exponent);
                p1 = p1.next;
            }else if(p2.exponent > p1.exponent){
                p.insertLast(p2.coefficient, p2.exponent);
                p2 = p2.next;
            }
        }
        while(p1 != null){
            p.insertLast(p1.coefficient, p1.exponent);
            p1 = p1.next;
        }
        while(p2 != null){
            p.insertLast(p2.coefficient, p2.exponent);
            p2 = p2.next;
        }
    }

    public static void main(String[] args) {
        PolynomialAdditionLinkedList.LinkedList p1 = new PolynomialAdditionLinkedList.LinkedList();
        p1.insertLast(3,2); //3x2 + 4x + 1
        p1.insertLast(4, 1);
        p1.insertLast(1, 0);

        PolynomialAdditionLinkedList.LinkedList p2 = new PolynomialAdditionLinkedList.LinkedList();
        p2.insertLast(4,2); //4x2 + 2x
        p2.insertLast(2, 1);

        p1.display();
        p2.display();
        addPoly(p1.head, p2.head);
        p.display();


    }

}
