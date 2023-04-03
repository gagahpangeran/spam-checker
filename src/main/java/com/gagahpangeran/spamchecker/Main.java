package com.gagahpangeran.spamchecker;

import com.gagahpangeran.spamchecker.checker.SpamChecker;

public class Main {
    private static String[] data = new String[] {
            "This is a spam email",
            "This is not a spam email",
            "Hello how are you?",
            "What a great day today",
    };

    public static void main(String[] args) {
        SpamChecker checker = new SpamChecker(data);
        checker.getVerdict();
    }
}