package Chapter15_DP;

// Reference Link : https://www.youtube.com/watch?v=jgiZlGzXMBw
// Reference Code Link : https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/ChangeMakingProblem/BottomUp.java

import java.util.*;
public class min_coin_change {

    private static int coin_change(int[] coins, int totalValue){
        int[] dp = new int[totalValue+1];

        // A placeholder value in array so that if there are no ways to get to a total, we need some big value.
        // A nice value to use as placeholder is (totalValue + 1) instead of Integer.MIN_VALUE or Integer.MAX_VALUE
        int max = totalValue + 1;
        Arrays.fill(dp, max);

        /*
          The answer to making change with minimum coins for 0
          will always be 0 coins no matter what the coins we are
          given are
        */
        dp[0] = 0;
        for(int i =1; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);

            }
        }
        return dp[totalValue] == max ? -1 : dp[totalValue];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int totalValue = 11;
        int min_coins = coin_change(coins, totalValue);
        System.out.println(min_coins);
    }
}
