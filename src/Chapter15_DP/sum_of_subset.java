package Chapter15_DP;

// Reference Link:  https://www.youtube.com/watch?v=K20Tx8cdwYY
//                  https://www.youtube.com/watch?v=5td2QH-x5ck
public class sum_of_subset {

    //Print DP Matrix
    private static void printDP(boolean[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean sum_of_subset(int[] numbers, int target){
        boolean[][] dp = new boolean[numbers.length+1][target+1];
        dp[0][0] = true;
        // Fill the first column with All TRUE, because it is possible to have a subset sum of zero
        for(int i = 1; i <= numbers.length; i++)
            dp[i][0] = true;

        // Fill the first row with FALSE, leaving the first column, because we can't make any target with number as 0
        for(int i = 1; i <= target; i++)
            dp[0][i] = false;

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(numbers[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - numbers[i-1]];
            }
        }
        return dp[numbers.length][target];
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,9,2};
        int target = 5;
        boolean result = sum_of_subset(numbers, target);
        System.out.println(result);
    }
}
