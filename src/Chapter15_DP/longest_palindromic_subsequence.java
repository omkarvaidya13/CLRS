package Chapter15_DP;

// Reference Link: https://www.youtube.com/watch?v=yZWmS6CXbQc

public class longest_palindromic_subsequence {
    //Print DP Matrix
    private static void printDP(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static int longest_palindromic_subsequence(String s){
        int n = s.length();
        int[][] dp = new int[n][n];

        // Fill diagonal elements since, all single letters are palindrome itself
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int len = 2; len <= n; len++){      // here len = length of substring starting from 2 to string length
            for(int i = 0; i < n - len + 1; i++){
                int end = i + len - 1;
                if(s.charAt(i) == s.charAt(end))
                    dp[i][end] = 2 + dp[i+1][end-1];
                else
                    dp[i][end] = Math.max(dp[i][end-1], dp[i+1][end]);
            }
        }
        printDP(dp);
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        String s = "adbbca";
        int result = longest_palindromic_subsequence(s);
        System.out.println(result);
    }
}
