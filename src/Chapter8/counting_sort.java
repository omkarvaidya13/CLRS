package Chapter8;

/*
    Time Complexity : O(n+k)
        where   n = number of elements
        and     k = number of possible values
 */


public class counting_sort {
    public static void counting_sort(int[] arr, int k){

        // Auxiliary array : of size (k+1) which acts as temporary working storage
        int[] c = new int[k+1];

        //Output array : to store the output. Size = length of input array
        int[] b = new int[arr.length];

        // Store the count of number of times each number occurs in the temporary storage.
        for(int i = 0; i < arr.length; i++){
            c[arr[i]] = c[arr[i]] + 1;
        }

        // Calculate the most rightmost index to store each element in the output array so that it will be sorted
        for(int i = 1; i < c.length; i++){
            c[i] = c[i] + c[i-1];

        }

        // Now insert into the the output array, element from input array into the index from temp storage
        // reduce the index in the temp storage for each element placed in the output array
        for(int i = arr.length-1; i >= 0; i--){
            b[c[arr[i]]-1] = arr[i];
            c[arr[i]] = c[arr[i]] - 1;
        }

        // Print the result from the output array
        for(int i : b)
            System.out.println(i);

    }
    public static void main(String[] args) {

        // Input array:
        int[] arr = new int[]{3,1,4,2};

        // Value of k: all the values in array will be less than equal to this value
        int k = 5;

        //Function call
        counting_sort(arr, k);
    }
}
