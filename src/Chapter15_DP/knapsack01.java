package Chapter15_DP;

// Reference Link:  https://www.youtube.com/watch?v=PfkBS9qIMRE&list=PLdo5W4Nhv31aBrJE1WS4MR9LRfbmZrAQu&index=6&t=2s
//                    https://www.youtube.com/watch?v=xCbYmUPvc2Q

public class knapsack01 {
    private static int knapsack01(int[] weights, int[] values, int totalWeight){
        int[][] dp = new int[weights.length+1][totalWeight+1];

        for(int i = 0; i <= weights.length; i++){
            for(int j = 0; j <= totalWeight; j++){
                // We don't have to do this in Java, directly start the loop from (1,1)
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(weights[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else {
                    int inclusive = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    int exclusive = dp[i - 1][j];
                    dp[i][j] = Math.max(inclusive, exclusive);
                }
            }
        }
        return dp[weights.length][totalWeight];
    }


    public static void main(String[] args) {
        int[] weights = {10,20,30};
        int[] values = {60,100,120};
        int totalWeight = 50;

        int result = knapsack01(weights, values, totalWeight);
        System.out.println(result);
    }
}
