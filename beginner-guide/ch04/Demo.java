package com.practice.demo;

import com.practice.stack.Stack;

public class Demo {

    public static void main(String[] args) {
        var stack = new Stack(3);
        stack.push("Hello").push("World").pop().peek();
        System.out.println(stack);
    }
}
