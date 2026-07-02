package com.practice.readafile;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadAFile {

    public static void main(String[] args) throws IOException {
        FileInputStream file = null;
        try {
            String filename = getFilename("Enter the filename: ");
            file = new FileInputStream(filename);
            while (file.available() > 0) {
                int data = file.read();
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }

    public static String getFilename(String msg) {
        Console con = System.console();
        if (con == null) {
            System.out.println("No console available");
            System.exit(1);
        }
        String input = con.readLine(msg);
        while (input == null || input.trim().isEmpty()) {
            input = con.readLine(msg);
        }
        return input.trim();
    }
}
