import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static boolean findRedundantBrackets(String s) 
    {
        // Write your code here.
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            boolean b2 = false, o2 = false, opr = false, o1 = false, b1 = false, all = false;
            char c = s.charAt(i);
            if(c == ')' && !b2){
                b2 = true;
                while(!st.isEmpty()){
                    char ch = st.pop();
                    if(ch == '*' || ch == '/' || ch == '+' || ch == '-' && !opr){
                        opr = true;
                    }
                    else if(Character.isLetter(ch) && b2 && !o2){
                        o2 = true;
                    }
                    else if(Character.isLetter(ch) && b2 && o2 && opr && !o1){
                        o1 = true;
                    }
                    else if(ch == '(' && !b1 && b2 && o2 && opr && o1){
                        b1 = true;
                    }

                    if(b1 && o1 && opr && o2 && b2){
                        st.push('X');
                        all = true;
                        break;
                    }

                }
                
                if(!all)
                    return true;
            }
            st.push(c);
            
        }
        return (st.size() == 1)? true: false;
    }
}
