//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    private static int precedence(char ch){
        if(ch == '^')return 2;
        if(ch == '/' || ch == '*')return 1;
        if(ch == '+'|| ch == '-')return 0;
        return -1;
    }
    public static String infixToPostfix(String exp) {
        Stack<Character> s = new Stack<>();
        String ans = "";
        int n = exp.length();
        for(int i = 0; i < n; i++){
            char ch = exp.charAt(i);
            if(Character.isLetter(ch))ans += ch;
            else if(ch == '(')s.push(ch);
            else if(ch == ')'){
                while(s.size() > 0 && s.peek() != '('){
                    ans += s.pop();
                }
                s.pop();
            }else{
                while(s.size() > 0 && precedence(ch) <= precedence(s.peek())){
                    ans += s.pop();
                }
                s.push(ch);
            }
        }
        while(s.size() > 0){
            ans += s.pop();
        }
        return ans;
    }
}