package com.practice.asciiswapper;

public class AsciiSwapper {

    public static void main(String[] args) {
        try {
            char swapped;
            while ((swapped = swapAscii(getAscii())) != '.') {
                System.out.print(swapped);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        var cons = System.console();
        var input = cons.readLine("Enter a string to swap: ");
        System.out.println(StringCharacterSwapping.swap(input));
    }

    public static char swapAscii(int input) {
        char c = (char) input;
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        } else if (c >= 'a' && c <= 'z') {
            return (char) (c - 32);
        }
        return c;
    }

    public static int getAscii() throws java.io.IOException {
        return System.in.read();
    }

    private static class StringCharacterSwapping {

        private static String swap(String input) {
            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                sb.append(swapAscii((int) c));
            }
            return sb.toString();
        }
    }
}
