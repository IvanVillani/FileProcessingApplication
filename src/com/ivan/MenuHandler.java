package com.ivan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHandler implements ActionListener {
    public MenuHandler() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileHandler fileHandler = new FileHandler();

        if ("Open".equals(e.getActionCommand())){
            fileHandler.openAction(e);
        }else if ("Save as".equals(e.getActionCommand())){
            fileHandler.saveAsAction(e);
        }else if ("Save".equals(e.getActionCommand())){
            fileHandler.saveAction(e);
        }
    }
}
