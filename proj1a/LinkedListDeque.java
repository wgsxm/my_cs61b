public class LinkedListDeque <T> {
    private Node sentinel;
    private int size;
    private class Node
    {
        public T item;
        public Node prev;
        public Node next;
        /**
         * Initializes a Node
         * @param item
         * @param prev
         * @param next
         */
        public Node(T item, Node prev, Node next)
        {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    /**
     * Initializes a LinkedListDeque
     */
    public LinkedListDeque()
    {
        this.sentinel=new Node(null,null,null);
        this.sentinel.prev=this.sentinel;
        this.sentinel.next=this.sentinel;
        this.size=0;
    }
    /**
     * Adds an item of type T to the front of the deque
     * @param item
     */
    public void addFirst (T item)
    {
        Node first=new Node(item,sentinel,sentinel.next);
        sentinel.next.prev=first;
        sentinel.next=first;
        size++;
    }
    public void addLast(T item)
    {
        Node last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size++;
    }

    /**
     * Determines whether the list is empty or not
     * @return
     */
    public boolean isEmpty(){
        if(size==0)return true;
        else return false;
    }

    /**
     * Gets the size of the list
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * Prints the items in the deque in turn
     */
    public void printDeque(){
        Node temp = sentinel.next;
        while(temp!=sentinel)
        {
            System.out.print(temp.item+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    /**
     * remove the node and return its item. If empty, return null.
     * @return
     */
    public T removeFirst()
    {
        if(isEmpty())return null;
        size--;
        Node ret = sentinel.next;
        sentinel.next = sentinel.next.next;
        ret.next.prev = sentinel;
        return ret.item;
    }
    public T removeLast()
    {
        if(isEmpty())return null;
        size--;
        Node ret = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        ret.prev.next = sentinel;
        return ret.item;
    }

    /**
     * Gets the item at the given index without altering the deque, using iteration
     * @param index
     * @return
     */
    public T get(int index)
    {
        if(index>=size()||index<0)return null;
        int iter=0;
        Node temp = sentinel.next;
        while(iter<index)
        {
            temp=temp.next;
            iter++;
        }
        return temp.item;
    }

    /**
     * Gets the item at the given index without altering the deque, but using recursion
     * @param index
     * @return
     */
    public T getRecursive(int index)
    {
        if(index>=size||index<0)return null;
        if(index==0)return sentinel.item;
        else {
            sentinel = sentinel.next;
            T ret = getRecursive(index-1);
            sentinel = sentinel.prev;
            return ret;
        }
    }
}
