import java.util.*;
import java.io.*;

public class Solution {
  public static void solve(Stack<Integer> st, int x) {
    if (st.isEmpty()){
      st.push(x);
      return;
    }

    int ele = st.pop();
    solve(st, x);
    st.push(ele);
  }

  public static Stack<Integer> pushAtBottom(Stack<Integer> st, int x) {
    // Write your code here
    solve(st, x);
    return st;
  }
}
