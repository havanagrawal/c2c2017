class LinkedListImplDriver {
    public static void main(String[] args) {
        testInsertAtHeadForEmptyList();
        testInsertAtHeadForList();
        testInsertAtTailForEmptyList();
        testInsertAtTailForList();
        testInsertAtK();
    }

    static void testInsertAtHeadForEmptyList() {
        ILinkedList ll = new LinkedListImpl();
        Node p = new Node(1);
        ll.insertAtHead(p);

        System.out.println("insertAtHeadForEmptyList works: " + (ll.getKth(0) == p));
    }

    static void testInsertAtHeadForList() {
        ILinkedList ll = new LinkedListImpl();
        Node p1 = new Node(1);
        Node p2 = new Node(2);
        ll.insertAtHead(p1);
        ll.insertAtHead(p2);

        System.out.println("insertAtHead works: " + (ll.getKth(0) == p2));
        ll.print();
    }

    static void testInsertAtTailForEmptyList() {
        ILinkedList ll = new LinkedListImpl();
        Node p = new Node(1);
        ll.insertAtTail(p);

        System.out.println("insertAtTailForEmptyList works: " + (ll.getKth(0) == p));
    }

    static void testInsertAtTailForList() {
        ILinkedList ll = new LinkedListImpl();
        Node p1 = new Node(1);
        Node p2 = new Node(2);
        ll.insertAtTail(p1);
        ll.insertAtTail(p2);

        boolean works = (ll.getKth(0) == p1) && (ll.getKth(1) == p2);

        System.out.println("insertAtTail works: " + works);
        ll.print();
    }

    static void testInsertAtK() {
        ILinkedList ll = new LinkedListImpl();
        Node p1 = new Node(1);
        Node p2 = new Node(4);
        ll.insertAtTail(p1);
        ll.insertAtTail(p2);

        ll.insertAtK(1, new Node(3));
        ll.insertAtK(1, new Node(2));

        boolean works = (ll.getKth(1).data == 2) && (ll.getKth(2).data == 3);

        System.out.println("insertAtK works: " + works);
        ll.print();
    }

}
