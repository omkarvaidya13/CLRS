package Chapter2;

/*
Consider the problem of adding two n-bit binary integers, stored in two n-element
arrays A and B. The sum of the two integers should be stored in binary form in
an .n C 1/-element array C. State the problem formally and write pseudocode for
adding the two integers.
 */

/* Pseudocode:
1: carry = 0
2: for i=n to 1 do
3: C[i + 1] = (A[i] + B[i] + carry) (mod 2)
4: if A[i] + B[i] + carry ≥ 2 then
5: carry = 1
6: else
7: carry = 0
8: end if
9: end for
10: C[1] = carry
 */

public class add_nbit_binary_integers {
    public static void add_nbit_binary_integers(int[] a, int[] b){
        int[] c = new int[a.length+1];
        int n = a.length;
        int carry = 0;
        for(int i = n-1; i >= 0; i--){
            c[i+1] = (a[i]+b[i]+carry)%2;   //mod 2 operation
            if(a[i]+b[i]+carry >= 2)
                carry = 1;
            else
                carry = 0;
        }
        c[0] = carry;
        for (int i : c)
            System.out.println(i);
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,1,0,0};   //12
        int[] b = new int[]{1,1,1,1};    //15
        add_nbit_binary_integers(a,b);
    }
}
