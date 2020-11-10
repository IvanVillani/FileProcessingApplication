package com.ivan;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;

public class FileSaver {
    private BufferedReader reader;
    private PrintWriter writer;
    private StringBuilder sb;
    private String textArea;

    public FileSaver(String fileName, String dir) {
        File file = new File(dir + "\\" + fileName);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
        new FileSaverAs(fileName, dir);
    }
}
