package Chapter2;

// Insertion Sort :

/* Pseudo Code: Ascending Order
1: for j = 2 to A.length do
2: key = A[j]
3: // Insert A[j] into the sorted sequence A[1..j − 1].
4: i = j − 1
5: while i > 0 and A[i] > key do
6: A[i + 1] = A[i]
7: i = i − 1
8: end while
9: A[i + 1] = key
10: end for
 */

/* Pseudo Code: Descending Order
1: for j = 2 to A.length do
2: key = A[j]
3: // Insert A[j] into the sorted sequence A[1..j − 1].
4: i = j − 1
5: while i > 0 and A[i] < key do
6: A[i + 1] = A[i]
7: i = i − 1
8: end while
9: A[i + 1] = key
10: end for
 */
public class insertion_sort {
    public static void isort_asc(int[] arr){

        for(int i =1; i < arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.println("Ascending Order: ");
        for(int i: arr)
            System.out.println(i);
    }

    public static void isort_desc(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] < key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.println("Descending Order: ");
        for(int i: arr)
            System.out.println(i);
    }

    public static void main(String[] args) {
        int[] a = new int[]{31,41,59,26,41,58};
        isort_asc(a);
        isort_desc(a);
    }
}
