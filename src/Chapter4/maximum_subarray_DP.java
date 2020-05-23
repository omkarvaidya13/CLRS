package Chapter4;

// Dynamic Programming:
public class maximum_subarray_DP {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] output = new int[arr.length];
        output[0] = arr[0];
        int maxSum = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(output[i-1]+arr[i] < arr[i]){
                output[i] = arr[i];
            }else {
                output[i] = output[i-1]+arr[i];
            }
            maxSum = Math.max(maxSum, output[i]);
        }
        System.out.println(maxSum);
    }
}
