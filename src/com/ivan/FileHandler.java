package com.ivan;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FileHandler extends JFrame {
    private final JTextField filename;
    private final JTextField dir;

    public FileHandler() {
        this.filename = new JTextField();
        this.dir = new JTextField();

    }

    public void openAction(ActionEvent e) {
        JFileChooser c = new JFileChooser();
        int rVal = c.showOpenDialog(FileHandler.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            filename.setText(c.getSelectedFile().getName());
            dir.setText(c.getCurrentDirectory().toString());
            new FileOpener(filename.getText(), dir.getText());
        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            filename.setText("You pressed cancel");
            dir.setText("");
        }
    }

    public void saveAsAction(ActionEvent e) {
        JFileChooser c = new JFileChooser();
        int rVal = c.showSaveDialog(FileHandler.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            filename.setText(c.getSelectedFile().getName());
            dir.setText(c.getCurrentDirectory().toString());
            new FileSaverAs(filename.getText(), dir.getText());
        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            filename.setText("You pressed cancel");
            dir.setText("");
        }
    }

    public void saveAction(ActionEvent e) {
        if (GUIControl.fileName == null || GUIControl.dir == null){
            saveAsAction(e);
        }else {
            new FileSaver(GUIControl.fileName, GUIControl.dir);
        }
    }
}
