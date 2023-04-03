package com.gagahpangeran.spamchecker.comparator;

public class LongestCommonSubsequenceComparator implements TextComparator {
    @Override
    public double getSimilarity(String text1, String text2) {
        int t1Len = text1.length();
        int t2Len = text2.length();

        int[][] dp = new int[t1Len + 1][t2Len + 1];

        for (int i = 1; i <= t1Len; i++) {
            for (int j = 1; j <= t2Len; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        double score = (double) dp[t1Len][t2Len] / Math.max(t1Len, t2Len);

        return score;
    }
}
