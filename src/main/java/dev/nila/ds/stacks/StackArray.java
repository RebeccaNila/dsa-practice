package dev.nila.ds.stacks;

public class StackArray {
    int size;
    int[] stack;
    int top = -1;
    StackArray(){
        size = 100;
        stack = new int[100];
    }

    void push(int data){
        if(top == size-1){
            //throw new Exception("Stack Overflow");
            System.out.println("Stack Overflow");
            return;

        }
        stack[++top] = data;
    }

    int pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    int peek(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top];
    }

    int isEmpty(){
        if(top == -1) return 1;
        return 0;
    }

    void display(){
        for(int i : stack){
            System.out.print(i+" -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
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
