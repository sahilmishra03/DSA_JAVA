package LinkedList;

public class LinkedListImplementation {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Methods

    // addAtFirst
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;

    }

    // addAtLast
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;

        tail = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // addAtMiddle
    public void addAtMiddle(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // removeFirst
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL IS EMPTY");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // removeLast
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL IS EMPTY");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        size--;
        return val;
    }

    // searchIterative
    public int searchIterative(int val) {
        int index = 0;
        Node ptr = head;
        while (ptr != null) {
            if (ptr.data == val) {
                return index;
            }
            ptr = ptr.next;
            index++;
        }
        return -1;
    }

    // helper
    public int helper(int val, Node head) {
        if (head == null) {
            return -1;
        }
        if (head.data == val) {
            return 0;
        }
        int index = helper(val, head.next);
        if (index == -1) {
            return -1;
        }
        return -1;
    }

    // searchrecursive
    public int searchrecursive(int val) {
        return helper(val, head);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteFromEnd(int n) {
        int size = 0;
        Node tNode = head;
        while (tNode != null) {
            tNode = tNode.next;
            size++;
        }

        if (n == size) {
            head = head.next;
            return;
        }

        int i = 1;
        int itoFind = size - n;
        Node prv = head;
        while (i <itoFind) {
            prv = prv.next;
            i++;
        }
        prv.next = prv.next.next;
        return;
    }

    public static void main(String[] args) {
        LinkedListImplementation ll = new LinkedListImplementation();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();
        ll.reverse();
        ll.print();
    }
}