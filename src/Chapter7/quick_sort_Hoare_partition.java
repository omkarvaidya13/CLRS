package Chapter7;
/*
Hoare's Partitioning Scheme :
https://www.geeksforgeeks.org/hoares-vs-lomuto-partition-scheme-quicksort/
Pseudocode :

partition(arr[], lo, hi)
   pivot = arr[lo]
   i = lo - 1  // Initialize left index
   j = hi + 1  // Initialize right index

   // Find a value in left side greater
   // than pivot
   do
      i = i + 1
   while arr[i] < pivot

   // Find a value in right side smaller
   // than pivot
   do
      j--;
   while (arr[j] > pivot);

   if i >= j then
      return j

   swap arr[i] with arr[j]
*/

public class quick_sort_Hoare_partition {
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low-1;
        int j = high+1;
        while (true){
            do {
                i++;
            }while (arr[i] < pivot);
            do {
                j--;
            }while (arr[j] > pivot);
            if (i >= j)
                return j;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    public static void qSort_hPart(int[] arr, int low, int high){
        if(low < high){
            int j = partition(arr, low, high);
            qSort_hPart(arr, low, j);
            qSort_hPart(arr, j+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,80,30,90,40,50,70};
        qSort_hPart(arr, 0, arr.length-1);
        for (int i: arr)
            System.out.println(i);
    }
}
