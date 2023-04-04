package com.gagahpangeran.spamchecker.comparator;

public class LongestCommonSubsequenceComparator implements TextComparator {
    @Override
    public double getSimilarity(String text1, String text2) {
        // convert to lowercase and remove punctuation
        text1 = text1.toLowerCase().replaceAll("\\p{Punct}", "");
        text2 = text2.toLowerCase().replaceAll("\\p{Punct}", "");

        // split text by whitespace into array
        String[] t1Arr = text1.split("\\s+");
        String[] t2Arr = text2.split("\\s+");

        int t1Len = t1Arr.length;
        int t2Len = t2Arr.length;

        int[][] dp = new int[t1Len + 1][t2Len + 1];

        for (int i = 1; i <= t1Len; i++) {
            for (int j = 1; j <= t2Len; j++) {
                if (t1Arr[i - 1].equals(t2Arr[j - 1])) {
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
