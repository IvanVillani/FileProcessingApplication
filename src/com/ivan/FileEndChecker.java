package com.ivan;

public class FileEndChecker {
    public FileEndChecker() {
        String text = GUIControl.textArea.getText();
        if ('\n' != text.charAt(text.length()-1)){
            GUIControl.textArea.setText(text + '\n');
        }
    }
}
