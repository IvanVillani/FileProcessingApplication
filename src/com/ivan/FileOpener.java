package com.ivan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOpener {
    private BufferedReader reader;

    public FileOpener(String fileName, String dir) {
        StringBuilder sb = new StringBuilder();
        try{
            reader = new BufferedReader(new FileReader(dir + "\\" + fileName));
            String line;
            while((line = reader.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }
            GUIControl.textArea.setText(sb.toString());
            GUIControl.cachedTextArea = GUIControl.textArea.getText();
            GUIControl.fileName = fileName;
            GUIControl.dir = dir;
            reader.close();

        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
