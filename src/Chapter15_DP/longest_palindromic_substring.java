package Chapter15_DP;

// Reference Link: https://www.youtube.com/watch?v=UflHuQj6MVA
public class longest_palindromic_substring {
    private static void printLongestPalindromicSubstring(String s, int low, int high){
        System.out.println("Longest Palindromic Substring is: "+s.substring(low, high));
    }

    private static int longest_palindromic_substring(String s){
        int n = s.length();
        int maxlength = 1;
        int printStartIndex = 0;
        int[][] dp = new int[n][n];

        // Fill the dp for all single letters - i.e diagonal elements
        for(int i = 0; i < dp.length; i++){
            dp[i][i] = 1;
        }

        //Fill the dp for all strings of length 2
        maxlength = 2;
        for(int i = 0; i < dp.length - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i + 1] = 1;
                printStartIndex = i;
            }
        }

        // Fill rest of the table
        // sub(i, j) = str[i] == str[j] && dp[i+1][j-1] == 1
        for(int len = 3; len <= n; len++){          // here len = length of substring starting from 3 to string length
            for(int i = 0; i < n - len + 1; i++){
                int end = i + len - 1;      // end index for substring in consideration right now.
                if(s.charAt(i) == s.charAt(end) && dp[i+1][end-1] == 1) {
                    dp[i][end] = 1;
                    if(len > maxlength) {
                        maxlength = len;
                        printStartIndex = i;
                    }
                }
            }
        }

        printLongestPalindromicSubstring(s, printStartIndex, printStartIndex + maxlength);
        return maxlength;
    }
    public static void main(String[] args) {
        String s = "aaaabbaa";
        int result = longest_palindromic_substring(s);
        System.out.println("Length : "+result);
    }
}
