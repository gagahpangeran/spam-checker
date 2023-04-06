package com.gagahpangeran.spamchecker.checker;

import com.gagahpangeran.spamchecker.comparator.CosineSimilarityComparator;
import com.gagahpangeran.spamchecker.comparator.LongestCommonSubsequenceComparator;
import com.gagahpangeran.spamchecker.comparator.TextComparator;
import com.gagahpangeran.spamchecker.model.Email;

import java.util.ArrayList;

public class SpamChecker {
    private static double SPAM_PROBABILITY_THRESHOLD = 0.7;

    private ArrayList<Email> emails;

    TextComparator comparator;

    public SpamChecker(String[] data) {
        this(data, TextComparatorMethod.LCS);
    }

    public SpamChecker(String[] data, TextComparatorMethod method) {
        this.emails = new ArrayList<>();
        this.setTextComparatorMethod(method);
        this.processData(data);
    }

    public void setTextComparatorMethod(TextComparatorMethod method) {
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

    public void getVerdict() {
        for (Email email : emails) {
            System.out.println("ID : " + email.getId());
            System.out.println("Content : " + email.getContent());
            System.out.println("Spam probability : " + email.getSpamProbability());
            System.out.println("Verdict : " +
                    (email.getSpamProbability() >= SPAM_PROBABILITY_THRESHOLD ? "Spam" : "Not Spam"));
            System.out.println();
        }
    }

    private void processData(String[] data) {
        for (int i = 0; i < data.length; i++) {
            emails.add(new Email(i, data[i]));
        }
    }
}
