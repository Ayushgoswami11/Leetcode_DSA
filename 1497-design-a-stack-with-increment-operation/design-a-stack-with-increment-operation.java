class CustomStack {
    private int[] stack;
    private int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1; // Pointer to the current top element
    }
    
    public void push(int x) {
        if (top < stack.length - 1) {
            top++;
            stack[top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) {
            return -1;
        }
        int val = stack[top];
        top--;
        return val;
    }
    
    public void increment(int k, int val) {
        // Increment the bottom k elements manually
        int limit = Math.min(k, top + 1);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}