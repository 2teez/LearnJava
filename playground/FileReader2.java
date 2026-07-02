package com.practice.filereader2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReader2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.print("Enter file path:");
        String path = scanner.nextLine();
        BufferedReader fr = new BufferedReader(new FileReader(getFile(path)));
        String line;
        while ((line = fr.readLine()) != null) {
            System.out.println(line);
        }
        fr.close();
    }

    public static File getFile(String path) {
        return new File(path);
    }
}
