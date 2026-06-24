package com.practice.queue;

public final class Queue {

    private Object[] items;
    private int size;

    public Queue(int capacity) {
        this.items = new Object[capacity];
        this.size = 0;
    }

    public Queue enqueue(Object item) {
        if (size == items.length) {
            throw new IllegalStateException("Queue is full");
        }
        items[size++] = item;
        return this;
    }

    public Queue dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        //System.arraycopy(items, 1, items, 0, size - 1);
        // reimplement the above using for and a private helper
        for (int i = 1; i < size; i++) {
            items[i - 1] = items[i];
        }
        items[size - 1] = null;
        size--;
        return this;
    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
