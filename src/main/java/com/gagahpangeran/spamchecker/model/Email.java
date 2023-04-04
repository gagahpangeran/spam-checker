package com.gagahpangeran.spamchecker.model;

import java.util.ArrayList;
import java.util.Collections;

public class Email {
    private int id;
    private String content;
    private ArrayList<Double> similarityScores;

    public Email(int id, String content) {
        this.id = id;
        this.content = content;
        this.similarityScores = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public void addSimilarityScore(double score) {
        this.similarityScores.add(score);
    }

    public double getSpamProbability() {
        if (similarityScores.size() == 0)
            return 0;

        Collections.sort(similarityScores);
        int mid = similarityScores.size() / 2;

        if (similarityScores.size() == 1)
            return similarityScores.get(mid);

        return (similarityScores.get(mid) + similarityScores.get(mid - 1)) / 2;
    }
}
