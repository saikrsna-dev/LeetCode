//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    // 	int a = 0;
    // 	int b = n - 1;
    // 	while(a < b){
    // 	    if(M[a][b] == 1)a++;
    // 	    else b--;
    // 	}
    	
    // 	for(int i = 0; i < n; i++){
    // 	    if((i != a) && (M[a][i] == 1 || M[i][a] == 0))return -1;
    // 	}
    // 	return a;
    
    
    
        int trusts[] = new int[n ];
        int trustedBy[] = new int[n];
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[i].length; j++){
                if(M[i][j] == 1){
                    trusts[i]++;
                    trustedBy[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(trusts[i] == 0 && trustedBy[i] == n - 1)return i;
        }
        return -1;
    }
}