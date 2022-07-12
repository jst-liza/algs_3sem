class Stack {

    private String[] signs;
    private int top;
    private int capacity;

    Stack(int size) {
        signs = new String[size];
        capacity = size;
        top = -1;
    }

    public void push(String currSign) {
        if (isFull()) {
            System.out.println("Stack overflow");
            System.exit(1);
        }
        signs[++top] = currSign;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return signs[top--];
    }

    public String top() {
        if (isEmpty()) {
            System.out.println("Expression was incorrect");
            System.exit(1);
        }
        return signs[top];
    }

    public int size() {
        return top + 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void stackOutput() {
        for (int i = 0; i <= top; i++) {
            System.out.print("Stack:\n");
            System.out.print(signs[i] + ", ");
        }
    }
}