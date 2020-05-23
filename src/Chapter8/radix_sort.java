package Chapter8;

/*
    Time Complexity : O(d*(n+b))
        where   n = number of elements
                d = maximum number of digits
                k = base ( number of possible buckets)
 */

public class radix_sort {

    private static int getMax(int[] arr, int n){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static void count_sort(int[] arr, int n, int pos){
        int[] count = new int[10];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            count[(arr[i]/pos)%10]++;
        }
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }
        for(int i = n-1; i >= 0; i--){
            b[count[(arr[i]/pos)%10]-1] = arr[i];
            count[(arr[i]/pos)%10] = count[(arr[i]/pos)%10] - 1;
        }
        System.arraycopy(b, 0, arr, 0, n);
    }

    private static void radix_sort(int[] arr, int n){
        int max = getMax(arr,n);
        for(int pos = 1; max / pos > 0; pos=pos*10){
            count_sort(arr, n, pos);
        }
    }

    public static void main(String[] args) {
        int[] arr = {432,8,530,90,88,231,11,45,677,199};
        radix_sort(arr, arr.length);
        for(int i : arr)
            System.out.println(i);
    }
}
