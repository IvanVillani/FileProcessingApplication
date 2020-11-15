package com.ivan;

import java.io.File;

public class FileSaver {
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
