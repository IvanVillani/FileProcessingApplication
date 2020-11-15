package com.ivan;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwapWords {
    private final int line1;
    private final int word1;
    private final int line2;
    private final int word2;

    public SwapWords(int line1, int word1, int line2, int word2) {
        this.line1 = line1 - 1;
        this.word1 = word1 - 1;
        this.line2 = line2 - 1;
        this.word2 = word2 - 1;
        swapWords();
    }

    private void swapWords(){
        Pattern pattern = Pattern.compile(".*\n");
        Matcher matcher = pattern.matcher(GUIControl.textArea.getText());
        List<String> lines = new ArrayList<>();

        while(matcher.find()){
            lines.add(matcher.group(0));
        }

        if (line1 <= line2 && line1 >= 0 && line1 < lines.size() && line2 < lines.size()){
            String Line1 = lines.get(line1);
            String[] whitespacesLine1 = Line1.split("[^\\s]+");
            String[] wordsLine1 = Line1.split("\\s+");
            String line1Indentation = "";
            if (whitespacesLine1.length == wordsLine1.length){
                line1Indentation = whitespacesLine1[0];
            }

            String Line2 = lines.get(line2);
            String[] whitespacesLine2 = Line2.split("[^\\s]+");
            String[] wordsLine2 = Line2.split("\\s+");
            String line2Indentation = "";
            if (whitespacesLine2.length == wordsLine2.length){
                line2Indentation = whitespacesLine2[0];
            }

            pattern = Pattern.compile("[^\\s]+\\s+");
            matcher = pattern.matcher(Line1);
            List<String> line1Words = new ArrayList<>();

            while(matcher.find()){
                line1Words.add(matcher.group(0));
            }

            matcher = pattern.matcher(Line2);
            List<String> line2Words = new ArrayList<>();

            while(matcher.find()){
                line2Words.add(matcher.group(0));
            }

            if (word1 >= 0 && word2 >= 0 && word1 < line1Words.size() && word2 < line2Words.size()){
                String line1Word = line1Words.get(word1);
                String line2Word = line2Words.get(word2);
                String newLine1;
                String newLine2;

                StringBuilder sb = new StringBuilder();
                sb.append(line1Indentation);
                if(line1 == line2){
                    for (int i = 0; i < line1Words.size(); i++) {
                        if (i == word1){
                            pattern = Pattern.compile("([^\\s]+)(\\s+)");
                            matcher = pattern.matcher(line2Word);
                            matcher.find();
                            sb.append(matcher.group(1));
                            matcher = pattern.matcher(line1Word);
                            matcher.find();
                            sb.append(matcher.group(2));
                        }else if (i == word2){
                            pattern = Pattern.compile("([^\\s]+)(\\s+)");
                            matcher = pattern.matcher(line1Word);
                            matcher.find();
                            sb.append(matcher.group(1));
                            matcher = pattern.matcher(line2Word);
                            matcher.find();
                            sb.append(matcher.group(2));
                        }else {
                            sb.append(line1Words.get(i));
                        }
                    }
                    newLine1 = sb.toString();

                    lines.set(line1, newLine1);
                }else {
                    for (int i = 0; i < line1Words.size(); i++) {
                        if (i == word1){
                            pattern = Pattern.compile("([^\\s]+)(\\s+)");
                            matcher = pattern.matcher(line2Word);
                            matcher.find();
                            sb.append(matcher.group(1));
                            matcher = pattern.matcher(line1Word);
                            matcher.find();
                            sb.append(matcher.group(2));
                        }else {
                            sb.append(line1Words.get(i));
                        }
                    }
                    newLine1 = sb.toString();

                    sb = new StringBuilder();
                    sb.append(line2Indentation);

                    for (int i = 0; i < line2Words.size(); i++) {
                        if (i == word2){
                            pattern = Pattern.compile("([^\\s]+)(\\s+)");
                            matcher = pattern.matcher(line1Word);
                            matcher.find();
                            sb.append(matcher.group(1));
                            matcher = pattern.matcher(line2Word);
                            matcher.find();
                            sb.append(matcher.group(2));
                        }else {
                            sb.append(line2Words.get(i));
                        }
                    }
                    newLine2 = sb.toString();

                    lines.set(line1, newLine1);
                    lines.set(line2, newLine2);
                }

                sb = new StringBuilder();

                for (String line : lines) {
                    sb.append(line);
                }

                GUIControl.textArea.setText(sb.toString());
            }
        }
    }
}
