package com.gagahpangeran.spamchecker;

import com.gagahpangeran.spamchecker.checker.SpamChecker;
import com.gagahpangeran.spamchecker.checker.TextComparatorMethod;

public class Main {
    private static String[] data = new String[] {
            "This is a spam email",
            "This is not a spam email",
            "This is not my spam email",
            "This is not your email",
            "This is your email",
            "This is my spam email",
            "Hello how are you?",
            "What a great day today",
    };

    public static void main(String[] args) {
        SpamChecker checker = new SpamChecker(data);

        checker.calculateSpamProbability();
        checker.printVerdict();

        checker.setTextComparatorMethod(TextComparatorMethod.CosineSimilarity);
        checker.calculateSpamProbability();
        checker.printVerdict();

        checker.setTextComparatorMethod(TextComparatorMethod.LCS);
        checker.setSpamThreshold(0.5);
        checker.calculateSpamProbability();
        checker.printVerdict();
    }
}