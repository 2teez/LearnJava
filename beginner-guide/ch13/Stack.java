package com.practice.stack;

public class Stack<T> {

    private T[] stack;
    private int size;

    private Stack(int capacity) {
        stack = (T[]) new Object[capacity];
        size = 0;
    }

    public static <T> Stack<T> of(int capacity) {
        return new Stack<>(capacity);
    }

    public Stack<T> push(T item) {
        if (size == stack.length) {
            throw new IllegalStateException("Stack is full");
        }
        stack[size++] = item;
        return this;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[--size];
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(stack[i]).append(" ");
        }
        return sb.toString();
    }
}
