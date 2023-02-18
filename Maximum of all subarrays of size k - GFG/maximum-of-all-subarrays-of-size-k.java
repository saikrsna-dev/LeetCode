//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    
    static int[] nextGreaterElementOnRight(int n, int[] arr){
		int ans[] = new int[n];
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < n; i++){
			while(s.size() > 0 && arr[i] > arr[s.peek()]){
				ans[s.peek()] = i;
				s.pop();
			}
			s.push(i);
		}
		while(s.size() > 0){
			ans[s.peek()] = n;
			s.pop();
		}
		return ans;
	}
    static ArrayList <Integer> max_of_subarrays(int arr[], int N, int K)
    {
        int nGe[] = nextGreaterElementOnRight(N, arr);
		ArrayList <Integer> ans = new ArrayList<>();
		int j = 0;
		for(int i = 0; i <= N - K; i++){
			//if j is lagging behind i make them equal
			if(j < i)j = i;
			//Keepp jumping j to nge[j] within the window
			while(nGe[j] < i + K){
				j = nGe[j];
			}
			//j will be pointing at your window maximum 
			ans.add(arr[j]);
		}
		return ans;
    }
}