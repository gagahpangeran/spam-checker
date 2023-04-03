package com.gagahpangeran.spamchecker.checker;

import com.gagahpangeran.spamchecker.model.Email;

import java.util.ArrayList;

public class SpamChecker {
    private static double SPAM_PROBABILITY_THRESHOLD = 0.7;
    private ArrayList<Email> emails = new ArrayList<>();

    public SpamChecker(String[] data) {
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
