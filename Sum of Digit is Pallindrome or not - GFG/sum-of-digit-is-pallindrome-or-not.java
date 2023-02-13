//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isDigitSumPalindrome(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isNumPalinndrome(String num){
        
        int si = 0, ei = num.length() - 1;
        if(si > ei)return true;
        if(num.charAt(si) != num.charAt(ei))return false;
        return isNumPalinndrome(num.substring(si + 1, ei));
    }
    int isDigitSumPalindrome(int N) {
        // code here
        int num = 0;
        while(N > 0){
            int rem = N % 10;
            num += rem;
            N = N/10;
        }
        if(num/10 == 0)return 1;
        if(isNumPalinndrome(num+""))return 1;
        return 0;
    }
}