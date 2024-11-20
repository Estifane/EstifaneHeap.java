public class Heap {

    private int[] heap;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Insert a new element into the heap
    public void insert(int data) {
        if (size == capacity) {
            System.out.println("Heap is full.");
            return;
        }

        heap[size] = data;
        size++;
        heapifyUp(size - 1);
    }

    // Remove the root element (highest priority)
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    // Heapify up operation to maintain heap property after insertion
    private void heapifyUp(int index) {
        while (index > 0 && heap[index] > heap[(index - 1) / 2]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // Heapify down operation to maintain heap property after deletion
    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Helper function to swap elements
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Get the current size of the heap
    public int getSize() {
        return size;
    }

    // Print the elements of the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(5);
        heap.insert(15);
        heap.insert(20);
        heap.insert(8);

        System.out.println("Heap Elements:");
        heap.printHeap();

        System.out.println("Extracted Max: " + heap.extractMax());
        
        System.out.println("Heap Elements after extraction:");
        heap.printHeap();
    }
}
