package com.practice.stack;

public final class Stack {

    private final Object[] items;
    private int size;

    public Stack(int size) {
        this.items = new Object[size];
        this.size = 0;
    }

    public Stack push(Object item) {
        if (size == items.length) {
            throw new IllegalStateException("Stack is full");
        }
        items[size++] = item;
        return this;
    }

    public Stack pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        return this;
    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return items[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(items[i]).append(" ");
        }
        return sb.toString();
    }
}
