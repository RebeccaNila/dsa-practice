package dev.nila.ds.queues;

public class QueueArrayInefficient {

    int[] arr;
    int front = -1;
    int rear = -1;
    int size = 3;
    QueueArrayInefficient(){
        arr = new int[size];
    }

    void enqueue(int data){
        if(rear == size -1 ) throw new IndexOutOfBoundsException("Queue is full");
        if(front == -1 && rear == -1){
            front++;
            arr[++rear] = data;
            return;
        }
        arr[++rear] = data;
    }

    int dequeue(){
        if(front == -1 || rear == -1 || front > rear ) throw new IndexOutOfBoundsException("Queue is empty");
        return arr[front++];

    }

    public static void main(String[] args) {
        QueueArrayInefficient queue = new QueueArrayInefficient();
        queue.enqueue(10);
        queue.enqueue(0);
        queue.enqueue(50);
        //queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
