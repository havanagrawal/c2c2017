/*
 * The reason this interface has been named with a preceding I,
 * is because there already exists a class called LinkedList in Java,
 * and we don't want any name collisions with that class.
 */
interface ILinkedList {
    // Print out all the elements separated by commas
    void print();

    /** Inserts the given element at the head of the list
     */
    void insertAtHead(Node n);

    /** Inserts the given element at the tail of the list
     * Bonus: Can you make this an O(1) operation?
     */
    void insertAtTail(Node n);

    /** Inserts the given node at the kth position in the list, assuming 0 based indexing
     * (0 is head)
     */
    void insertAtK(int k, Node n);

    /** Deletes the element at head
     * It should return a reference to the deleted node
     */
    Node deleteHead();

    /** Deletes the element at tail
     * It should return a reference to the deleted node
     */
    Node deleteTail();

    /** Deletes the kth element in the list, assuming 0 based indexing
     * (0 is head)
     * It should return a reference to the deleted node
     */
    Node deleteKth(int k);

    /** Return a reference to the node at the kth position, assuming 0 based indexing
     * getKth(0) should return head,
     * getKth(size() - 1) should return a reference to tail
     */
    Node getKth(int k);

    /**
     * Returns the current size of the list
     * Bonus: Can you make this an O(1) operation?
     */
    int size();
}
