//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    
    public static boolean nodetoRootPath(Node root, int target, ArrayList<Node> ans){
        if(root == null)return false;
        
        if(root.data == target){
            ans.add(root);
            return true;
        }
        boolean res = nodetoRootPath(root.left, target, ans) || nodetoRootPath(root.right, target, ans);
        if(res)ans.add(root);
        return res;
    }
    
    public static void getNodesDown(Node root, int k, Node blockNode, ArrayList<Integer> ans){
        if(root == null ||  root == blockNode)return;
        if(k == 0){
            ans.add(root.data);
            return;
        }
        getNodesDown(root.left, k - 1, blockNode, ans);
        getNodesDown(root.right, k - 1, blockNode, ans);
        
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Node> path = new ArrayList<>();
        nodetoRootPath(root, target, path);
        
        ArrayList<Integer> ans = new ArrayList<>();
        Node blockNode = null;
        for(int i = 0; i < path.size(); i++){
            getNodesDown(path.get(i), k - i, blockNode, ans);
            blockNode = path.get(i);
        }
        Collections.sort(ans);
        return ans;
    }
};