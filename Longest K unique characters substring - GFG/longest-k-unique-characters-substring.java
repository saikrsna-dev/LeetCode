//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        int start = 0, end = 0, uniq = 0, ans = -1;
        int farr[] = new int[123];
        
        while(end < n){
            farr[s.charAt(end)]++;
            if(farr[s.charAt(end)] == 1)uniq++;
            end++;
            
            while(start < end && uniq > k){
                farr[s.charAt(start)]--;
                if(farr[s.charAt(start)] == 0)uniq--;
                start++;
            }
            
            if(uniq == k)ans = Math.max(ans, end - start);
        }
        return ans;
        
    }
}