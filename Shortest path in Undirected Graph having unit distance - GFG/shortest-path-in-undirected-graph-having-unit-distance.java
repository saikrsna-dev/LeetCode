//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] bfs(ArrayList<Integer>[] graph, int src, int vertices){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        int ans[] = new int[vertices];
        Arrays.fill(ans, -1);
        int level = 0;
        q.add(src);
        visited[src] = true;
        
        while(q.size() > 0){
            int n = q.size();
            for(int i = 0; i < n; i++){
                int temp = q.remove();
                ans[temp] = level;
                for(int nbr : graph[temp]){
                    if(!visited[nbr]){
                        q.add(nbr);
                        visited[nbr] = true;
                    }
                }
            }
            level++;
        }
        return ans;
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return bfs(graph, src, n);
    }
}