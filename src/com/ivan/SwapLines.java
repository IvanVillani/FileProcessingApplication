package com.ivan;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwapLines {
    private final int line1;
    private final int line2;

    public SwapLines(int line1, int line2) {
        this.line1 = line1 - 1;
        this.line2 = line2 - 1;
        swapLines();
    }

    private void swapLines(){
        Pattern pattern = Pattern.compile(".*\n");
        Matcher matcher = pattern.matcher(GUIControl.textArea.getText());
        List<String> lines = new ArrayList<>();

        while(matcher.find()){
            lines.add(matcher.group(0));
        }

        if (line1 < line2 && line1 >= 0 && line1 < lines.size() - 1 && line2 < lines.size()){
            String temp = lines.get(line1);
            lines.set(line1, lines.get(line2));
            lines.set(line2, temp);

            StringBuilder sb = new StringBuilder();

            for (String line : lines) {
                sb.append(line);
            }

            GUIControl.textArea.setText(sb.toString());
        }
    }
}
