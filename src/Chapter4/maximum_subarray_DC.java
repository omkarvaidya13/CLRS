package Chapter4;

// Divide and Conquer:
public class maximum_subarray_DC {

    public static int max_subArray(int[] arr){
        return recur(arr, 0, arr.length-1);
    }

    public static int max_crossing(int[] arr, int i, int m, int j){
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        for(int k = m; k >= i; k--){
            sum += arr[k];
            if(sum > left_sum){
                left_sum = sum;
            }
        }
        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        for (int k = m+1; k <= j; k++){
            sum += arr[k];
            if(sum > right_sum){
                right_sum = sum;
            }
        }
        return left_sum+right_sum;
    }

    public static int recur(int[] arr, int i, int j){
        if (i == j)
            return arr[i];
        int mid = (i + j)/2;
        int left = recur(arr, i, mid);
        int right = recur(arr, mid+1, j);
        int middle = max_crossing(arr, i, mid, j);

        return Math.max(middle, Math.max(left, right));
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = max_subArray(arr);
        System.out.println(result);
    }
}
