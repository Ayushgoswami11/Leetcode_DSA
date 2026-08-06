class MyCircularQueue {
    private final int[] queue;
    private int head;
    private int tail;
    private int count;
    private final int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.head = 0;
        this.tail = -1; // Allows first enQueue to place value at index 0
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        tail = (tail + 1) % capacity;
        queue[tail] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        head = (head + 1) % capacity;
        count--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : queue[tail];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}