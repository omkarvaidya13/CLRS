package Chapter2;

public class merge_sort {
    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= end){
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (i = start; i <= end; i++)
            arr[i] = temp[i-start];
    }

    public static void merge_sort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{3,41,52,26,38,57,9,49};
        merge_sort(a,0,a.length-1);
        for (int i: a)
            System.out.println(i);
    }
}
