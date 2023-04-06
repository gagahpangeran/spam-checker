package com.gagahpangeran.spamchecker.comparator;

import java.util.HashMap;
import java.util.HashSet;

public class CosineSimilarityComparator extends AbstractTextComparator {
    @Override
    public double getSimilarity(String text1, String text2) {
        String[] t1Arr = this.processString(text1);
        String[] t2Arr = this.processString(text2);

        HashMap<String, Integer> t1WordCount = getWordCount(t1Arr);
        HashMap<String, Integer> t2WordCount = getWordCount(t2Arr);

        double dotProduct = calculateDotProduct(t1WordCount, t2WordCount);

        double norm1 = 0;
        for (Integer value : t1WordCount.values()) {
            norm1 += Math.pow(value, 2);
        }

        double norm2 = 0;
        for (Integer value : t2WordCount.values()) {
            norm2 += Math.pow(value, 2);
        }

        double similarity = dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));

        return similarity;
    }

    private HashMap<String, Integer> getWordCount(String[] textArr) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : textArr) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    private double calculateDotProduct(HashMap<String, Integer> vector1, HashMap<String, Integer> vector2) {
        // get all the same words between two vector
        HashSet<String> intersection = new HashSet<>(vector1.keySet());
        intersection.retainAll(vector2.keySet());

        double result = 0;
        for (String word : intersection) {
            result += vector1.get(word) * vector2.get(word);
        }

        return result;
    }
}
