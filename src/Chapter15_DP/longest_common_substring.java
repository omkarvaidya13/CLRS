package Chapter15_DP;
import java.util.*;

// Reference Link: https://www.youtube.com/watch?v=UZRkpGk943Q

public class longest_common_substring {
    //Print DP Matrix
    private static void printDP(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void printAllLongestCommonSubstring(List<String> result){
        for(String s: result)
            System.out.println(s);
    }

    private static int longest_common_substring(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLength = Integer.MIN_VALUE;
        List<String> result = null;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                // If either string s1 or string s2 is empty, then there is no common substring between them.
                if(i == 0 || j == 0)        // we don't have to do this explicitly in java
                    dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
//                    maxLength = Math.max(maxLength, dp[i][j]);
                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                        result = new ArrayList<>();
                        result.add(s1.substring(i - maxLength, i));
                    }else if(dp[i][j] == maxLength){
                        result.add(s1.substring(i - maxLength, i));
                    }
                }
                else
                    dp[i][j] = 0;
            }
        }
//        printDP(dp);
        printAllLongestCommonSubstring(result);
        return maxLength;
    }
    public static void main(String[] args) {
        String s1 = "lclc";
        String s2 = "clcl";
        int result = longest_common_substring(s1, s2);
        System.out.println("Length of longest common substring is: "+result);
    }
}
