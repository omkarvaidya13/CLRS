package Chapter15_DP;

// Coin Change Problem :
//    Reference Link: https://www.youtube.com/watch?v=L27_JpN6Z1Q&list=PLdo5W4Nhv31aBrJE1WS4MR9LRfbmZrAQu&index=2
//                    https://www.youtube.com/watch?v=PafJOaMzstY

public class coin_change {
    //Print DP Matrix
    private static void printDP(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int coin_change(int[] coins, int totalValue){
        int[][] dp = new int[coins.length+1][totalValue+1];
        dp[0][0] = 1;       //since there is 1 way to make total 0 i.e when we don't select any coin.

        //populate the first row to all zeros (leaving first column), since by taking coin denomination 0, we can't make any total.
        // I am not doing this anymore, because in JAVA by default the array is initialized with zero's.
//        for(int j = 1; j < dp[0].length; j++){
//            dp[0][j] = 0;
//        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }

        printDP(dp);

        return dp[coins.length][totalValue];
    }


    public static void main(String[] args) {
        int[] coins = {2,3,5,10};
        int totalValue = 15;
        int no_of_ways = coin_change(coins, totalValue);
        System.out.println(no_of_ways);
    }
}
