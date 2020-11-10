package com.ivan;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSaverAs {
    private PrintWriter writer;
    private StringBuilder sb;
    private String textArea;

    public FileSaverAs(String fileName, String dir) {
        try {
            File newFile = new File(dir + "\\" + fileName);
            if (newFile.createNewFile()) {
                writer = new PrintWriter(newFile);
                sb = new StringBuilder();
                textArea = GUIControl.textArea.getText();
                writer.println(textArea);
                writer.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally{
            if (writer != null)
                writer.close();
        }
    }
}
