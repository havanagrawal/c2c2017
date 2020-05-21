class LinkedListImpl implements ILinkedList {

    private Node head;
    private int size;

    @Override
    public void print() {
        Node iter = head;
        while (iter != null) {
            System.out.print(iter.data + ", ");
            iter = iter.next;
        }
        System.out.println();
    }

    @Override
    public void insertAtHead(Node n) {
        n.next = head;
        head = n;
        size++;
    }

    @Override
    public void insertAtTail(Node n) {

        if (head == null) {
            insertAtHead(n);
        }

        Node iter = head;
        while (iter.next != null) {
            iter = iter.next;
        }

        iter.next = n;
        n.next = null;

        size++;
    }

    @Override
    public void insertAtK(int k, Node n) {
        if (k == 0) {
            insertAtHead(n);
        }
        else if (k >= size) {
            insertAtTail(n);
        }
        else {
            Node justBeforeK = getKth(k - 1);
            n.next = justBeforeK.next;
            justBeforeK.next = n;

            size++;
        }
    }

    @Override
    public Node deleteHead() {
        Node wasHead = head;

        if (head != null) {
            head = head.next;
            size--;
        }

        return wasHead;
    }

    @Override
    public Node deleteTail() {
        Node iter = head;

        // Empty list
        if (iter == null) {
            return null;
        }

        // List with single element
        if (iter.next == null) {
            Node wasTail = iter;
            head = null;
            size--;
            return wasTail;
        }

        Node justBeforeTail = getKth(size - 2);
        Node wasTail = justBeforeTail.next;
        justBeforeTail.next = null;

        size--;

        return wasTail;
    }

    @Override
    public Node deleteKth(int k) {
        if (k >= size) {
            return null;
        }

        if (k == 0) {
            deleteHead();
        }

        if (k == size - 1) {
            deleteTail();
        }

        Node justBeforeKth = getKth(k - 1);
        Node willBeDeleted = justBeforeKth.next;
        justBeforeKth.next = justBeforeKth.next.next;

        return willBeDeleted;
    }

    @Override
    public Node getKth(int k) {
        if (k >= size) {
            return null;
        }

        Node iter = head;
        int i = 0;

        while (i != k) {
            iter = iter.next;
            i++;
        }

        return iter;
    }

    @Override
    public int size() {
        return size;
    }

}
