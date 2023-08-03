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
        for (int i = front + 1, j = 0; j < size; i++, j++) {
            if (i >= items.length) {
                i = 0;
            }
            newItems[j] = items[i];
        }
        this.back = this.size;
        this.front = capacity - 1;
        this.items = newItems;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0 ? true : false;
    }

    public void addFirst(T item) {
        if (size >= items.length) {
            this.resize(this.size() * 2);
        }
        size++;
        items[front] = item;
        front = front > 0 ? front - 1 : items.length - 1;
    }

    public void addLast(T item) {
        if (size >= items.length) {
            this.resize(this.size() * 2);
        }
        size++;
        items[back] = item;
        back = back < items.length - 1 ? back + 1 : 0;
    }

    public void printDeque() {
        for (int i = front + 1, j = 0; j < size; i++, j++) {
            if (i >= items.length) {
                i = 0;
            }
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
            items[front + 1] = null;
            front++;
        } else {
            ret = items[0];
            items[0] = null;
            front = 0;
        }
        size--;
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
            items[back - 1] = null;
            back--;
        } else {
            ret = items[items.length - 1];
            items[items.length - 1] = null;
            back = items.length - 1;
        }
        size--;
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
