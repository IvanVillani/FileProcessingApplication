package com.ivan;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;

public class LineNumberTextArea extends JTextArea {
    private final JTextArea textArea;

    public LineNumberTextArea(JTextArea textArea)
    {
        this.textArea = textArea;
        setBackground(Color.LIGHT_GRAY);
        Font font = textArea.getFont();
        float size = font.getSize();
        setFont(font.deriveFont(size));
        setEditable(false);
    }

    public void updateLineNumbers()
    {
        String lineNumbersText = getLineNumbersText();
        setText(lineNumbersText);
    }

    private String getLineNumbersText()
    {
        int caretPosition = textArea.getDocument().getLength();
        Element root = textArea.getDocument().getDefaultRootElement();
        StringBuilder lineNumbersTextBuilder = new StringBuilder();
        lineNumbersTextBuilder.append("1").append(System.lineSeparator());

        for (int elementIndex = 2; elementIndex < root.getElementIndex(caretPosition) + 2; elementIndex++)
        {
            lineNumbersTextBuilder.append(elementIndex).append(System.lineSeparator());
        }

        return lineNumbersTextBuilder.toString();
    }
}
