public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int back;
    private static final int ORIGINAL_CAPACITY = 8;

    /**
     * create a empty deque
     */
    public ArrayDeque() {
        items = (T[]) new Object[ORIGINAL_CAPACITY];
        front = ORIGINAL_CAPACITY - 1;
        back = 0;
        size = 0;
    }

    /**
     * resize the deque
     *
     * @param capacity the target capacity
     */
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 0; i < back; i++) {
            newItems[i] = items[i];
        }
        for (int i = items.length - 1, j = newItems.length - 1; i > front; i--, j--) {
            newItems[j] = items[i];
        }
        this.front = this.front + capacity - items.length;
        this.items = newItems;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0 ? true : false;
    }

    public void addFirst(T item) {
        if (back > front) {
            this.resize(this.size() * 2);
        }
        size++;
        items[front] = item;
        front--;
    }

    public void addLast(T item) {
        if (back > front) {
            this.resize(this.size() * 2);
        }
        size++;
        items[back] = item;
        back++;
    }

    public void printDeque() {
        for (int i = front + 1; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        for (int i = 0; i < back; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T ret;
        if (front < items.length - 1) {
            ret = items[front + 1];
        } else {
            ret = items[0];
        }
        size--;
        front++;
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return ret;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T ret;
        if (back > 0) {
            ret = items[back - 1];
        } else {
            ret = items[items.length - 1];
        }
        size--;
        back--;
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return ret;
    }

    public T get(int index) {
        if (index > size && index < 0) {
            return null;
        }
        return items[(front + index + 1) % items.length];
    }
}
