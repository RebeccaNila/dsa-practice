package dev.nila.ds.queues;

public class QueueArray {

    int[] arr;
    int rear = -1;
    int size = 3;
    QueueArray(){
        arr = new int[size];
    }

    void enqueue(int data){
        if(rear == size - 1 ) throw new IndexOutOfBoundsException("Queue is full");
        arr[++rear] = data;
    }

    int dequeue(){
        if(rear == -1 ) throw new IndexOutOfBoundsException("Queue is empty");
        int temp = arr[0];
        for(int i = 1; i <= rear; i++){
            arr[i-1] = arr[i];
        }
        rear--;
        return temp;
    }

    void display(){
        for(int i : arr){
            System.out.print(i+" -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray();
        queue.enqueue(10);
        queue.enqueue(0);
        queue.enqueue(50);
        //queue.enqueue(5);
        queue.display();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
    }
}
