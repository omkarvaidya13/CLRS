package Chapter7;
/*
Lomuto's Partitioning Scheme :
https://www.geeksforgeeks.org/hoares-vs-lomuto-partition-scheme-quicksort/
Pseudocode :

partition(arr[], lo, hi)
    pivot = arr[hi]
    i = lo     // place for swapping
    for j := lo to hi – 1 do
    if arr[j] <= pivot then
    swap arr[i] with arr[j]
    i = i + 1
    swap arr[i] with arr[hi]
    return i
*/

public class quick_sort_Lomuto_partition {
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low;
        for(int j = low; j < high; j++){
            if (arr[j] <= pivot) {
//                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void qSort_lPart(int[] arr, int low, int high){
        if(low < high){
            int j = partition(arr, low, high);
            qSort_lPart(arr, low, j-1);
            qSort_lPart(arr,j+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,41,52,26,38,57,9,49};
        qSort_lPart(arr, 0, arr.length-1);
        for (int i: arr)
            System.out.println(i);
    }
}
