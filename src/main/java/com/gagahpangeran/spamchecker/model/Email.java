package com.gagahpangeran.spamchecker.model;

import java.util.ArrayList;

public class Email {
    private int id;
    private String content;
    private double spamProbability;
    private ArrayList<Double> similarityScores;

    public Email(int id, String content) {
        this.id = id;
        this.content = content;
        this.spamProbability = 0;
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
        return this.spamProbability;
    }
}
