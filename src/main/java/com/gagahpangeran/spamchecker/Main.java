package com.gagahpangeran.spamchecker;

import com.gagahpangeran.spamchecker.checker.SpamChecker;
import com.gagahpangeran.spamchecker.checker.TextComparatorMethod;

public class Main {
    private static String[] data = new String[] {
            "This is a spam email",
            "This is not a spam email",
            "Hello how are you?",
            "What a great day today",
    };

    public static void main(String[] args) {
        SpamChecker checker = new SpamChecker(data);

        checker.calculateSpamProbability();
        checker.getVerdict();

        checker.setTextComparatorMethod(TextComparatorMethod.CosineSimilarity);
        checker.calculateSpamProbability();
        checker.getVerdict();
    }
}