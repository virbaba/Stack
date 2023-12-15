import java.util.*;

public class Solution {
  public static void preSmaller(int[] pre, ArrayList<Integer> heights, int n) {
    Stack<Integer> st = new Stack<>();
    st.push(-1);

    for (int i = 0; i < n; i++) {
      int e = heights.get(i);
      if (st.size() > 1 && e <= heights.get(st.peek())) {
        while (st.size() > 1 && e <= heights.get(st.peek())) {
          st.pop();
        }
      }
      pre[i] = st.peek();
      st.push(i);
    }
  }

  public static void nextSmaller(int[] next, ArrayList<Integer> heights, int n) {
    Stack<Integer> st = new Stack<>();
    st.push(n);

    for (int i = n - 1; i >= 0; i--) {
      int e = heights.get(i);
      if (st.size() > 1 && e <= heights.get(st.peek())) {
        while (st.size() > 1 && e <= heights.get(st.peek())) {
          st.pop();
        }
      }
      next[i] = st.peek();
      st.push(i);
    }
  }

  public static int largestRectangle(ArrayList<Integer> heights) {
    // Write your code here.
    int n = heights.size();
    int[] pre = new int[n];
    int[] next = new int[n];

    preSmaller(pre, heights, n);
    nextSmaller(next, heights, n);

    int max = Integer.MIN_VALUE;
    int index = -1;

    for(int i = 0; i < n; i++){
      int e1 = pre[i];
      int e2 = next[i];

      int diff = (Math.max(e1, e2) - Math.min(e1, e2)) - 1;
      int prod = heights.get(i) * diff;

      if(max < prod)
        max = prod;
     
    }

    return max;

  }
}
