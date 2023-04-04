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

        // The LCS is the text1 itself, so the expected score is
        // word count of text1 divided by word count of text2 = 4/5
        double expectedScore = 0.8;

        Assertions.assertEquals(expectedScore, score, epsilon);
    }

    @Test
    void textsShouldHaveLowSimilarity() {
        String text1 = "My name is GPR";
        String text2 = "This is not your house";

        double score = comparator.getSimilarity(text1, text2);

        // The LCS is 'is' (1 word), so the expected score is
        // word count of LCS divided by length of text2 = 1/5
        double expectedScore = 0.2;

        Assertions.assertEquals(expectedScore, score, epsilon);
    }
}
