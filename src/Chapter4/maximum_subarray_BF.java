package Chapter4;

// Brute Force : Complexity - O(n^2)
public class maximum_subarray_BF {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = arr[0];
        for (int i =0; i < arr.length-1; i++){
            int sum = 0;
            for (int j = i+1; j < arr.length; j++){
                sum += arr[j];
                if(sum > maxSum)
                    maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }
}
