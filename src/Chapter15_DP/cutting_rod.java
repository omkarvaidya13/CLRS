package Chapter15_DP;

// Reference Link : https://www.youtube.com/watch?v=UMlFFFXj9Bw

public class cutting_rod {
    //Bottom Up approach - DP
    private static int cutting_rod(int[] p, int rod_length){
        int[] result = new int[rod_length+1];
        result[0] = 0;
        for(int i = 1; i <= rod_length; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 1; j <= i; j++){
                max = Math.max(max, p[j-1]+result[i-j]);
            }
            result[i] = max;
        }
        return result[rod_length];
    }
    public static void main(String[] args) {
        int[] p = {1,5,8,9,10,17,17,20,24,30};
        int rod_length = 4;
        int profit = cutting_rod(p,rod_length);
        System.out.println(profit);
    }
}
