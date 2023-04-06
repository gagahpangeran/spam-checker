package com.gagahpangeran.spamchecker.comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CosineSimilarityComparatorTest {
    double epsilon = 1e-9;
    TextComparator comparator = new CosineSimilarityComparator();

    @Test
    void textsShouldBeSimilar() {
        String text1 = "This is a text";
        String text2 = "This is a text";

        double score = comparator.getSimilarity(text1, text2);

        Assertions.assertEquals(1, score, epsilon);
    }

    @Test
    void textsShouldNotBeSimilar() {
        String text1 = "This is a text";
        String text2 = "Hello world";

        double score = comparator.getSimilarity(text1, text2);

        Assertions.assertEquals(0, score, epsilon);
    }

    @Test
    void textsShouldHaveHighSimilarity() {
        String text1 = "This is a text";
        String text2 = "This is not a text";

        double score = comparator.getSimilarity(text1, text2);
        double expectedScore = 0.8944271909999159;

        Assertions.assertEquals(expectedScore, score, epsilon);
    }

    @Test
    void textsShouldHaveLowSimilarity() {
        String text1 = "My name is GPR";
        String text2 = "This is not your house";

        double score = comparator.getSimilarity(text1, text2);
        double expectedScore = 0.22360679774997896;

        Assertions.assertEquals(expectedScore, score, epsilon);
    }
}
