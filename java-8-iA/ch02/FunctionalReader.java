package com.practice.functionalreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FunctionalReader {

    public static void main(String[] args) throws IOException {
        var con = System.console();
        if (con == null) {
            System.out.println("No console available");
            return;
        }

        var filePath = con.readLine("Enter file path: ");
        var result = processFile(filePath, reader -> {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        });
        System.out.println(result);
    }

    public static String processFile(
        String filePath,
        FileReaderProcessor processor
    ) throws IOException {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(filePath))
        ) {
            return processor.process(reader);
        } catch (IOException e) {
            throw e;
        }
    }
}

@FunctionalInterface
interface FileReaderProcessor {
    String process(BufferedReader reader) throws IOException;
}
