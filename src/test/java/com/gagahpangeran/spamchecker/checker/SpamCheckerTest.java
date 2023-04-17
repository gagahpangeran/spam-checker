package com.gagahpangeran.spamchecker.checker;

import com.gagahpangeran.spamchecker.model.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SpamCheckerTest {
    String[] data = new String[] {
            "This is a spam email",
            "This is not a spam email",
            "This is not my spam email",
            "This is not your email",
            "This is your email",
            "Hello how are you?",
            "What a great day today",
    };

    double epsilon = 1e-9;

    @Test
    void getSpamProbability() {
        SpamChecker checker = new SpamChecker(data);
        checker.calculateSpamProbability();

        double[] expectedScores = new double[] {
                0.6,
                0.5833333333333333,
                0.5833333333333333,
                0.6333333333333333,
                0.5,
                0,
                0,
        };

        ArrayList<Email> emails = checker.getEmails();

        for (int i = 0; i < emails.size(); i++) {
            Assertions.assertEquals(expectedScores[i], emails.get(i).getSpamProbability(), epsilon);
        }
    }

    @Test
    void spamProbabilityShouldNotChangeAfterMultipleCalculation() {
        SpamChecker checker = new SpamChecker(data);

        double[] expectedScores = new double[] {
                0.6,
                0.5833333333333333,
                0.5833333333333333,
                0.6333333333333333,
                0.5,
                0,
                0,
        };

        checker.calculateSpamProbability();
        ArrayList<Email> emails = checker.getEmails();

        for (int i = 0; i < emails.size(); i++) {
            Assertions.assertEquals(expectedScores[i], emails.get(i).getSpamProbability(), epsilon);
        }

        checker.setTextComparatorMethod(TextComparatorMethod.CosineSimilarity);
        checker.calculateSpamProbability();
        checker.setTextComparatorMethod(TextComparatorMethod.LCS);
        checker.calculateSpamProbability();

        emails = checker.getEmails();

        for (int i = 0; i < emails.size(); i++) {
            Assertions.assertEquals(expectedScores[i], emails.get(i).getSpamProbability(), epsilon);
        }
    }
}
