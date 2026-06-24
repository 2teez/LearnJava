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
}
