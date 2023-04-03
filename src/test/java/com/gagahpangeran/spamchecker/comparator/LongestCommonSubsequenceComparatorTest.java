package com.gagahpangeran.spamchecker.comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubsequenceComparatorTest {
    double epsilon = 1e-9;
    TextComparator comparator = new LongestCommonSubsequenceComparator();

    @Test
    void textsShouldBeSimilar() {
        String text1 = "This is a text";
        String text2 = "This is a text";

        double score = comparator.getSimilarity(text1, text2);

        Assertions.assertEquals(score, 1, epsilon);
    }

    @Test
    void textsShouldNotBeSimilar() {
        String text1 = "abcd";
        String text2 = "efgh";

        double score = comparator.getSimilarity(text1, text2);

        Assertions.assertEquals(score, 0, epsilon);
    }

    @Test
    void textsShouldHaveHighSimilarity() {
        String text1 = "Hello world!";
        String text2 = "Hello to the world!";

        double score = comparator.getSimilarity(text1, text2);

        // The LCS is the text1 itself, so the expected score is
        // length of text1 divided by length of text2 = 12/19
        double expectedScore = 0.631578947368421;

        Assertions.assertEquals(score, expectedScore, epsilon);
    }

    @Test
    void textsShouldHaveLowSimilarity() {
        String text1 = "Good morning";
        String text2 = "Java is sick!";

        double score = comparator.getSimilarity(text1, text2);

        // The LCS is ' i' (2 characters), so the expected score is
        // length of LCS divided by length of text2 = 2/13
        double expectedScore = 0.15384615384615385;

        Assertions.assertEquals(score, expectedScore, epsilon);
    }
}
