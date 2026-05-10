package dev.nila.ds.arrays;

public class DynamicArray {

    private int[] arr;     // array
    private int size;      // Number of elements currently in array
    private int capacity;  // Total capacity of array

    // Constructor
    public DynamicArray(int capacity){
        this.arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    // Get element at index
    private int get(int index){
        if(index < 0 || index >= size){
            System.out.println("Get failed: Invalid index");
            return -1;
        }
        return arr[index];
    }

    // Set element at index
    private void set(int index, int element){
        if(index < 0 || index >= size) {
            System.out.println("Set failed: Invalid index");
        }else{
            arr[index] = element;
        }

    }
    // Insert at index
    private boolean insert(int index, int element){
        if(index < 0 || index > size){
            System.out.println("Insert failed: Invalid index or array is full");
            return false;
        }
        if(size >= capacity) resize();
        for(int i = size; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
        return true;
    }

    private void display(){
        for(int i = 0; i < size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // Search for element (returns index or -1)
    private int search(int target){
        for(int i = 0; i<size; i++){
            if(arr[i] == target) return i;
        }
        return -1;
    }


    // Delete at index
    private boolean delete(int index){
        if(index < 0 || index >= size){
            System.out.println("Delete failed: Invalid index");
            return false;
        }
        for(int i = index; i<size-1; i++){
            arr[i] = arr[i+1];
        }
        size--;
        return true;
    }

    // Get current size
    public int getSize() {
        return size;
    }

    // Get capacity
    public int getCapacity() {
        return capacity;
    }

    public void resize(){
        capacity = 2*capacity;
        int[] newArr = new int[capacity];
        for(int i = 0; i<size; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // Main method to test
    public static void main(String[] args){
        DynamicArray array = new DynamicArray(5);

        array.insert(0, 10);
        array.insert(1, 20);
        array.insert(2, 30);
        array.insert(1, 15);  // Insert in between
        array.insert(3, 1);
        array.insert(4, 2);
        array.insert(5, 3);
        array.display();  // Expected: 10 15 20 30

        array.set(2, 25);
        System.out.println("Element at index 2: " + array.get(2));  // Expected: 25

        array.delete(1);
        array.display();  // Expected: 10 25 30

        System.out.println("Index of 30: " + array.search(30)); // Expected: 2
    }

    /**
     * Time Complexity of each Operation
     * Operation	Time Complexity
     * Access	    O(1)
     * Search	    O(n)
     * Insert	    O(n)
     * Delete	    O(n)
     */
}
