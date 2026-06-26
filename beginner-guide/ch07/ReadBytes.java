package com.practice.readbytes;

public class ReadBytes {

    public static void main(String[] args) throws java.io.IOException {
        var data = new byte[10];
        System.out.println("Enter 10 bytes:");
        System.in.read(data);
        System.out.println(new String(data));
    }
}
