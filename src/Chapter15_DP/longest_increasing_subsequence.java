package Chapter15_DP;

import java.util.*;

public class longest_increasing_subsequence {
    // Print DP
    private static void printDP(int[] dp){
        for(int i : dp)
            System.out.println(i);
    }
    private static int longest_increasing_subsequence(int[] nums){
        if(nums == null || nums.length < 1)
            return 0;
        int[] dp = new int[nums.length];
        int maxLength = 1;
        // Fill all positions of array with 1, since all single elements are individual subsequences too.
        Arrays.fill(dp, 1);

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            if(dp[i] > maxLength)
                maxLength = dp[i];
        }
//        printDP(dp);
        return maxLength;
    }
    public static void main(String[] args) {
//        int[] arr = {0,4,12,2,10,6,9,13,3,11,7,15};
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = longest_increasing_subsequence(arr);
        System.out.println("Length of longest increasing subsequence: "+result);
    }
}
