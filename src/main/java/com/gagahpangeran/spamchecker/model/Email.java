package com.gagahpangeran.spamchecker.model;

public class Email {
    private int id;
    private String content;
    private double spamProbability;

    public Email(int id, String content) {
        this.id = id;
        this.content = content;
        this.spamProbability = 0;
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public double getSpamProbability() {
        return this.spamProbability;
    }
}
