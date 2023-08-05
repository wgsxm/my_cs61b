public class LinkedListDeque<T> implements Deque<T> {
    private Node sentinel;
    private int size;

    private class Node {
        private T item;
        private Node prev;
        private Node next;

        /**
         * Initializes a Node
         *
         * @param item the item of the Node
         * @param prev the previous Node of the Node
         * @param next the next Node of the Node
         */
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Initializes a LinkedListDeque
     */
    public LinkedListDeque() {
        this.sentinel = new Node(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

    /**
     * Adds an item of type T to the front of the deque
     *
     * @param item the item to add to the front of the deque
     */
    @Override
    public void addFirst(T item) {
        Node first = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size++;
    }

    /**
     * @return whether the deque is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    /**
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque in turn
     */
    @Override
    public void printDeque() {
        Node temp = sentinel.next;
        while (temp != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * remove the node and return its item. If empty, return null.
     *
     * @return the item of the first node if it exists, otherwise return null.
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size--;
        Node ret = sentinel.next;
        sentinel.next = sentinel.next.next;
        ret.next.prev = sentinel;
        return ret.item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size--;
        Node ret = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        ret.prev.next = sentinel;
        return ret.item;
    }

    /**
     * Gets the item at the given index without altering the deque, using iteration
     *
     * @param index the index of the wanted Node in the deque.
     * @return the item of the given node.
     */
    @Override
    public T get(int index) {
        if (index >= size() || index < 0) {
            return null;
        }
        int iter = 0;
        Node temp = sentinel.next;
        while (iter < index) {
            temp = temp.next;
            iter++;
        }
        return temp.item;
    }

    /**
     * Gets the item at the given index without altering the deque, but using recursion
     *
     * @param index as followed
     * @return
     */

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        } else {
            sentinel = sentinel.next;
            T ret = getRecursive(index - 1);
            sentinel = sentinel.prev;
            return ret;
        }
    }
}
