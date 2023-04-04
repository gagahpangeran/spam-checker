package com.gagahpangeran.spamchecker.checker;

import com.gagahpangeran.spamchecker.comparator.LongestCommonSubsequenceComparator;
import com.gagahpangeran.spamchecker.comparator.TextComparator;
import com.gagahpangeran.spamchecker.model.Email;

import java.util.ArrayList;

public class SpamChecker {
    private static double SPAM_PROBABILITY_THRESHOLD = 0.7;
    private ArrayList<Email> emails;

    TextComparator comparator;

    public SpamChecker(String[] data) {
        this.emails = new ArrayList<>();
        this.comparator = new LongestCommonSubsequenceComparator();
        this.processData(data);
    }

    public void getVerdict() {
        for (Email email : emails) {
            System.out.println("Email id : " + email.getId());
            System.out.println("Email content : " + email.getContent());
            System.out.println("Email verdict : " +
                    (email.getSpamProbability() >= SPAM_PROBABILITY_THRESHOLD ? "Spam" : "Not Spam"));
        }
    }

    private void processData(String[] data) {
        for (int i = 0; i < data.length; i++) {
            emails.add(new Email(i, data[i]));
        }
    }
}
