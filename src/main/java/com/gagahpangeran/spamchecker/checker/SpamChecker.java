package com.gagahpangeran.spamchecker.checker;

import com.gagahpangeran.spamchecker.comparator.CosineSimilarityComparator;
import com.gagahpangeran.spamchecker.comparator.LongestCommonSubsequenceComparator;
import com.gagahpangeran.spamchecker.comparator.TextComparator;
import com.gagahpangeran.spamchecker.model.Email;

import java.util.ArrayList;

public class SpamChecker {
    private ArrayList<Email> emails;

    private double spamThreshold;

    private TextComparatorMethod method;

    private TextComparator comparator;

    public SpamChecker(String[] data) {
        this(data, 0.6, TextComparatorMethod.LCS);
    }

    public SpamChecker(String[] data, double spamThreshold, TextComparatorMethod method) {
        this.emails = new ArrayList<>();
        this.setSpamThreshold(spamThreshold);
        this.setTextComparatorMethod(method);
        this.processData(data);
    }

    public void setSpamThreshold(double spamThreshold) {
        this.spamThreshold = spamThreshold;
    }

    public void setTextComparatorMethod(TextComparatorMethod method) {
        this.method = method;

        switch (method) {
            case LCS:
                comparator = new LongestCommonSubsequenceComparator();
                break;
            case CosineSimilarity:
                comparator = new CosineSimilarityComparator();
                break;
        }
    }

    public void calculateSpamProbability() {
        for (int i = 0; i < emails.size() - 1; i++) {
            for (int j = i + 1; j < emails.size(); j++) {
                Email email1 = emails.get(i);
                Email email2 = emails.get(j);

                double similarity = comparator.getSimilarity(email1.getContent(), email2.getContent());

                email1.addSimilarityScore(similarity);
                email2.addSimilarityScore(similarity);
            }
        }
    }

    public void printVerdict() {
        int spamCounter = 0;
        System.out.println("----------------------");
        System.out.println("Spam Checker Result");
        for (Email email : emails) {
            boolean isSpam = email.getSpamProbability() >= spamThreshold;
            spamCounter += isSpam ? 1 : 0;

            System.out.println("ID : " + email.getId());
            System.out.println("Content : " + email.getContent());
            System.out.println("Spam probability : " + email.getSpamProbability());
            System.out.println("Verdict : " + (isSpam ? "Spam" : "Not Spam"));
            System.out.println();
        }

        System.out.println("Text comparator method : " + this.method);
        System.out.println("Spam Probability Threshold : " + this.spamThreshold);
        System.out.println(spamCounter + " spam email(s) of " + emails.size() + " email(s)");
        System.out.println("----------------------");
    }

    private void processData(String[] data) {
        for (int i = 0; i < data.length; i++) {
            emails.add(new Email(i, data[i]));
        }
    }
}
