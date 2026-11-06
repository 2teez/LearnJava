package com.practice.practgeneric;

import java.util.ArrayList;
import java.util.stream.Collectors;

class PractGeneric {

    public static void main(String[] args) throws EmptyStackException {
        var names = new Stack().push("java").push("clojure").push("groove.");
        System.out.println(names);
        names.pop();
        names.push("rust");
        names.pop(0);
        System.out.println(names);
        System.out.println(names.peek());
        //
        var nums = new Stack<>().push(34).push(23).push(7);

        System.out.println(nums);
        nums.pop(1);
        System.out.println(nums);
    }
}

class Stack<T> {

    private final ArrayList<T> values;

    public Stack() {
        values = new ArrayList<T>();
    }

    public Stack<T> push(T value) {
        values.add(value);
        return this;
    }

    public T pop() throws EmptyStackException {
        if (values.size() <= 0) {
            throw new EmptyStackException("Empty Stack.");
        }
        return values.remove(values.size() - 1);
    }

    public T pop(int index) throws EmptyStackException {
        if (values.size() < 0 || index > values.size()) {
            throw new EmptyStackException(
                String.format("index specified: %d. Is out of Range.", index)
            );
        }
        return values.remove(index);
    }

    public T peek() throws EmptyStackException {
        if (values.size() <= 0) {
            throw new EmptyStackException("Empty Stack. Nonthing to see.");
        }
        return values.get(values.size() - 1);
    }

    @Override
    public String toString() {
        return values
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
    }
}

class EmptyStackException extends Exception {

    String message;

    public EmptyStackException(String message) {
        super(message);
    }
}
