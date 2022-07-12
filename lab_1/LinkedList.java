class LinkedList {

    Node head = new Node();

    class Node{
        int data;
        Node next = null;
        public Node(int data){
            this.data = data;
        }
        public Node(){}
    }

    public void insertHead(int val) {
        Node newnode = new Node(val);
        if(head.next != null) {
            newnode.next = head.next;
        }
        head.next = newnode;
    }

    public void insertTail(int val) {
        Node newnode = new Node(val);
        Node walkPointer = head;
        while(walkPointer.next != null) {
            walkPointer = walkPointer.next;
        }
        walkPointer.next = newnode;
    }

    public void insert(int pos, int val) {
        int index = 0;
        if(pos >= 0 && pos <= this.getLength()) {
            Node walkPointer = head;
            while(index != pos) {
                walkPointer = walkPointer.next;
                index++;
            }
            Node newnode = new Node(val);
            newnode.next = walkPointer.next;
            walkPointer.next = newnode;
        }
        else
            System.out.println("Incorrect position");
    }

    public int getLength() {
        int length = 0;
        Node walkPointer = head;
        while(walkPointer.next != null) {
            walkPointer = walkPointer.next;
            length++;
        }
        return length;
    }

    public boolean delete(Node delnode) {
        if(delnode == null || delnode.next == null) {
            return false;
        }
        delnode = delnode.next;
        return true;
    }

    public void print() {
        Node walkPointer = head;
        System.out.println("Linked list:");
        while(walkPointer.next != null) {
            walkPointer = walkPointer.next;
            System.out.print(walkPointer.data + " ");
        }
    }

}