package com.ivan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionHandler implements ActionListener {
    private JTextField func1_line1;
    private JTextField func1_line2;
    private JTextField func2_line1;
    private JTextField func2_word1;
    private JTextField func2_line2;
    private JTextField func2_word2;
    private JButton func1_button;
    private JButton func2_button;
    private final int functionChecker;

    public FunctionHandler() {
        this.functionChecker = 0;
    }

    public FunctionHandler(JTextField func1_line1, JTextField func1_line2) {
        this.func1_line1 = func1_line1;
        this.func1_line2 = func1_line2;
        this.functionChecker = 1;
    }

    public FunctionHandler(JTextField func2_line1, JTextField func2_word1, JTextField func2_line2, JTextField func2_word2) {
        this.func2_line1 = func2_line1;
        this.func2_word1 = func2_word1;
        this.func2_line2 = func2_line2;
        this.func2_word2 = func2_word2;
        this.functionChecker = 2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new FileEndChecker();
        GUIControl.isSwapped++;

        if (GUIControl.isSwapped == 1){
            GUIControl.cachedTextArea = GUIControl.textArea.getText();
        }else{
            GUIControl.isSwapped--;
        }

        if (functionChecker == 0){
            new ResetText();
            System.out.println("dddd");
        }else if (functionChecker == 1) {
            int line1 = Integer.parseInt(func1_line1.getText());
            int line2 = Integer.parseInt(func1_line2.getText());
            new SwapLines(line1, line2);
        } else if (functionChecker == 2) {
            int line1 = Integer.parseInt(func2_line1.getText());
            int word1 = Integer.parseInt(func2_word1.getText());
            int line2 = Integer.parseInt(func2_line2.getText());
            int word2 = Integer.parseInt(func2_word2.getText());
            new SwapWords(line1, word1, line2, word2);
        }
    }
}
