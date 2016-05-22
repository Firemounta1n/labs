package com.Lab_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Paginator paginator = new Paginator();

        //Надо вынести в тесты:
        try {
            String html = paginator.html(1, 20);
            String fileName = "index.html";

            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(html);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}