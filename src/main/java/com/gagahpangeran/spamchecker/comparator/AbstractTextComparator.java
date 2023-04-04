package com.gagahpangeran.spamchecker.comparator;

public abstract class AbstractTextComparator implements TextComparator {
    @Override
    public abstract double getSimilarity(String text1, String text2);

    protected String[] processString(String text) {
        // convert to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("\\p{Punct}", "");

        // split text by whitespace into array
        String[] textArr = text.split("\\s+");

        return textArr;
    }
}
