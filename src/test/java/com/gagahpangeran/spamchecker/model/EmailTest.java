package com.gagahpangeran.spamchecker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void spamProbabilityShouldBeZero() {
        Email email = new Email(0, "content");

        Assertions.assertEquals(0, email.getSpamProbability());
    }

    @Test
    void spamProbabilityScoreWithOddData() {
        Email email = new Email(0, "content");
        for (int i = 1; i <= 5; i++) {
            email.addSimilarityScore(i);
        }

        // similarity scores = [1, 2, 3, 4, 5]
        // the median is 3
        Assertions.assertEquals(3, email.getSpamProbability());
    }

    @Test
    void spamProbabilityScoreWithEvenData() {
        Email email = new Email(0, "content");

        for (int i = 1; i <= 4; i++) {
            email.addSimilarityScore(i);
        }

        // similarity scores = [1, 2, 3, 4]
        // the median is (3+2)/2 = 2.5
        Assertions.assertEquals(2.5, email.getSpamProbability());
    }
}
