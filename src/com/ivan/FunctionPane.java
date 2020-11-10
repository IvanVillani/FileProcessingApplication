package com.ivan;

import javax.swing.*;
import java.awt.*;

public class FunctionPane extends JPanel {
    public FunctionPane(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        JPanel function1Panel = addFunction1Contents(gbc);
        JPanel function2Panel = addFunction2Contents(gbc);
        JPanel resetButtonPanel = addResetButton(gbc);
        add(function1Panel, gbc);
        gbc.gridx++;
        add(new JPanel(), gbc);
        gbc.gridx++;
        add(function2Panel, gbc);
        gbc.gridx++;
        add(resetButtonPanel, gbc);

    }

    private JPanel addResetButton(GridBagConstraints gbc){
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridBagLayout());
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton func1_reset = new JButton("Reset");
        func1_reset.addActionListener(new FunctionHandler());
        gbc.gridx++;
        newPanel.add(func1_reset, gbc);
        return newPanel;
    }

    private JPanel addFunction1Contents(GridBagConstraints gbc){
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridBagLayout());
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel function1Label = new JLabel("Swap lines: ");
        newPanel.add(function1Label, gbc);
        JTextField func1_line1 = new JTextField(5);
        gbc.gridx++;
        newPanel.add(func1_line1, gbc);
        JLabel function1Label_a = new JLabel("(first line number)");
        gbc.gridx++;
        newPanel.add(function1Label_a, gbc);
        JTextField func1_line2 = new JTextField(5);
        gbc.gridx--;
        gbc.gridy++;
        newPanel.add(func1_line2, gbc);
        JLabel function1Label_b = new JLabel("(second line number)");
        gbc.gridx++;
        newPanel.add(function1Label_b, gbc);
        JButton func1_swap = new JButton("Swap");
        func1_swap.addActionListener(new FunctionHandler(func1_line1, func1_line2));
        gbc.gridx--;
        gbc.gridy++;
        newPanel.add(func1_swap, gbc);

        return newPanel;
    }

    private JPanel addFunction2Contents(GridBagConstraints gbc){
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridBagLayout());
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        JLabel function2Label = new JLabel("Swap words: ");
        newPanel.add(function2Label, gbc);
        JTextField func2_line1 = new JTextField(5);
        gbc.gridx++;
        newPanel.add(func2_line1, gbc);
        JLabel function2Label_a1 = new JLabel("(first line number)");
        gbc.gridwidth = 2;
        gbc.gridx++;
        newPanel.add(function2Label_a1, gbc);
        JTextField func2_word1 = new JTextField(5);
        gbc.gridwidth = 1;
        gbc.gridx++;
        newPanel.add(func2_word1, gbc);
        JLabel function2Label_a2 = new JLabel("(first word position)");
        gbc.gridwidth = 2;
        gbc.gridx++;
        newPanel.add(function2Label_a2, gbc);
        JTextField func2_line2 = new JTextField(5);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy++;
        newPanel.add(func2_line2, gbc);
        JLabel function2Label_b1 = new JLabel("(second line number)");
        gbc.gridx++;
        newPanel.add(function2Label_b1, gbc);
        JTextField func2_word2 = new JTextField(5);
        gbc.gridx++;
        newPanel.add(func2_word2, gbc);
        JLabel function2Label_b2 = new JLabel("(second word position)");
        gbc.gridx++;
        newPanel.add(function2Label_b2, gbc);
        JButton func2_swap = new JButton("Swap");
        func2_swap.addActionListener(new FunctionHandler(func2_line1, func2_word1, func2_line2, func2_word2));
        gbc.gridx = 1;
        gbc.gridy++;
        newPanel.add(func2_swap, gbc);

        return newPanel;
    }
}
