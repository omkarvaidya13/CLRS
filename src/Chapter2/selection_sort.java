package Chapter2;

// Selection Sort :

/* Pseudo Code :
1: for i = 1 to n − 1 do
2: min = i
3: for j = i + 1 to n do
4: // Find the index of the i
th smallest element
5: if A[j] < A[min] then
6: min = j
7: end if
8: end for
9: Swap A[min] and A[i]
10: end for

 */
public class selection_sort {
    public static void selection_sort(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        for(int i : arr)
            System.out.println(i);
    }
    public static void main(String[] args) {
        int[] a = new int[]{5,2,4,6,1,3};
        selection_sort(a);
    }
}
