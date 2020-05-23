package Chapter15_DP;

// Reference Link: https://www.youtube.com/watch?v=jHGgXV27qtk&list=PLdo5W4Nhv31aBrJE1WS4MR9LRfbmZrAQu&index=9&t=0s

public class longest_common_subsequence {
    //Print DP Matrix
    private static void printDP(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int longest_common_subsequence(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                // We don't have to do this in Java, directly start the loop from (1,1)
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        String s1 = "abaaba";
        String s2 = "babbab";
        int result = longest_common_subsequence(s1, s2);
        System.out.println(result);
    }
}
