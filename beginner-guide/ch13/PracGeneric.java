package com.practice.pracgeneric;

import com.practice.stack.Stack;

public class PracGeneric {

    public static void main(String[] args) {
        var stack = Stack.of(3);
        stack.push(1).push(2).push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.push(4);
        try {
            stack.push(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        var wordSallad = "Idris is a type dependent programming language";
        var wrds = Stack.of(wordSallad.split(" ").length);
        for (var word : wordSallad.split(" ")) {
            wrds.push(word.trim());
        }
        System.out.println(wrds);

        while (!wrds.isEmpty()) {
            System.out.println(wrds.pop());
        }
    }
}
