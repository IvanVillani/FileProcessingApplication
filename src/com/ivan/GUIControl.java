package com.ivan;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class GUIControl {
    public JFrame frame;
    static JTextArea textArea;
    static String cachedTextArea;
    static int isSwapped = 0;
    static String fileName;
    static String dir;

    public GUIControl() {
        frame = new JFrame("File Processing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        JScrollPane jsp = new JScrollPane();

        textArea = new JTextArea();
        Font font = textArea.getFont();
        float size = font.getSize() + 4.0f;
        textArea.setFont(font.deriveFont(size));

        LineNumberTextArea lineNumberTextArea = new LineNumberTextArea(textArea);

        textArea.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent documentEvent)
            {
                lineNumberTextArea.updateLineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent)
            {
                lineNumberTextArea.updateLineNumbers();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent)
            {
                lineNumberTextArea.updateLineNumbers();
            }
        });

        jsp.getViewport().add(textArea);
        jsp.setRowHeaderView(lineNumberTextArea);

        JMenuBar menuBar = new JMenuBar();
        JMenu tab1 = new JMenu("File");
        menuBar.add(tab1);
        JMenuItem openTab = new JMenuItem("Open");
        openTab.addActionListener(new MenuHandler());
        JMenuItem saveTab = new JMenuItem("Save");
        saveTab.addActionListener(new MenuHandler());
        JMenuItem saveAsTab = new JMenuItem("Save as");
        saveAsTab.addActionListener(new MenuHandler());
        tab1.add(openTab);
        tab1.add(saveTab);
        tab1.add(saveAsTab);

        frame.add(BorderLayout.NORTH, menuBar);
        frame.add(BorderLayout.CENTER, jsp);
        frame.add(BorderLayout.SOUTH, new FunctionPane());
        frame.setVisible(true);
    }
}
