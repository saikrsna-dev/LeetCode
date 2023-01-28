//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}


// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
     public Node findLCA(Node root, int p, int q) {
        if(root == null)return root;
        if(root.data == p || root.data == q)return root;

        Node lft = findLCA(root.left, p, q);
        Node ryt = findLCA(root.right, p, q);

        if(lft != null && ryt != null)return root;
        if(lft == null && ryt == null)return null;
        if(lft == null)return ryt;
        return lft;
    }
    int findDist(Node root, int a, int b) {
        Node lca = findLCA(root, a, b);
        
        int x = pathlength(lca, a, 0);
        int y = pathlength(lca, b, 0);
        return x + y;
    }
    int pathlength(Node root, int a, int level){
        if(root == null)return -1;
        if(root.data == a)return level;
        int left = pathlength(root.left, a, level + 1);
        if(left == -1)return pathlength(root.right, a, level + 1);
        
        return left;
    }
}

/*boolean findpath(Node root, int a, ArrayList<Integer> path){
        if(root == null)return false;
        if(root.data == a){
            path.add(root.data);
            return true;
        }
        
        boolean res = findpath(root.left, a, path);
        res = res|| findpath(root.right, a, path);
        if(res)path.add(root.data);
        return res;
    }
    int findDist(Node root, int a, int b) {
        ArrayList<Integer> pathA = new ArrayList<>();
        ArrayList<Integer> pathB = new ArrayList<>();
        findpath(root, a, pathA);
        findpath(root, b, pathB);
        
        int i = pathA.size() - 1;
        int j = pathB.size() - 1;
        int count = 0;
        while(i >= 0 && j >= 0){
            if(pathA.get(i) != pathB.get(j))break;
            count++;
            i--;
            j--;
        }
        return pathA.size() + pathB.size() - 2*count;
    }*/