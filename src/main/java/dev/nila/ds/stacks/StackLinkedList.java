package dev.nila.ds.stacks;

class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class StackLinkedList {
    Node top = null;

    void push(int data){
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    int pop(){
        if(top == null){
            System.out.println("Stack Underflow");
            return -1;
        }
        int temp = top.data;
        top = top.next;
        return temp;
    }

    int peek() {
        if(top == null){
            System.out.println("Stack Underflow");
            return -1;
        }
        return top.data;
    }

    int isEmpty(){
        if(top == null) return 1;
        return 0;
    }

    void display(){
        Node temp = top;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(5);
        stack.push(1);
        stack.push(7);
        stack.push(6);
        stack.display();
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }

}
