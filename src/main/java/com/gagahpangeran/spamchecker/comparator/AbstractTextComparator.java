package com.gagahpangeran.spamchecker.comparator;

public abstract class AbstractTextComparator implements TextComparator {
    @Override
    public abstract double getSimilarity(String text1, String text2);
}
