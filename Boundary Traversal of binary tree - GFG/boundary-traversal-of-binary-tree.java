//{ Driver Code Starts
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
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
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
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    void leftBoundary(Node root, List<Integer> path){
        if(root == null)return;
        
        // if(root.left == null && root.right == null)return already taken care by below code
        
        if(root.left != null){
            path.add(root.data);
            leftBoundary(root.left, path);
        }
        else if(root.right != null){
            path.add(root.data);
            leftBoundary(root.right, path);
        }
    }
    
    void rightBoundary(Node root, List<Integer> path){
        if(root == null)return;
        
        // if(root.left == null && root.right == null)return already taken care by below code
        
        if(root.right != null){
            
            rightBoundary(root.right, path);
            path.add(root.data);
        }else if(root.left != null){
            
            rightBoundary(root.left, path);
            path.add(root.data);
        }
    }
    
    void leafNode(Node root, List<Integer> path){
        if(root == null)return;
        
        if(root.right == null && root.left == null){
            path.add(root.data);
            return;
        }
        leafNode(root.left, path);
        leafNode(root.right, path);
    }
	ArrayList <Integer> boundary(Node root)
	{
	    
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(root == null)return ans;
	    if(root.left == null && root.right == null){
	        ans.add(root.data);
	        return ans;
	    }
	    List<Integer> left = new ArrayList<>();
	    leftBoundary(root.left, left);
	    
	    List<Integer> right = new ArrayList<>();
	    rightBoundary(root.right, right);
	    
	    List<Integer> leaf = new ArrayList<>();
	    leafNode(root, leaf);
	    
	   // 1 add your root
	   ans.add(root.data);
	   
	   //2 add left boundary
	   for(int i = 0; i < left.size(); i++)ans.add(left.get(i));
	   
	   //3 add Leaves
	   for(int i = 0; i < leaf.size(); i++)ans.add(leaf.get(i));
	   
	   //4 add right boundary
	   //for(int i = right.size() - 1; i >= 0; i--)ans.add(right.get(i));
	   for(int i = 0; i < right.size(); i++)ans.add(right.get(i));
	   
	   return ans;
	}
}
