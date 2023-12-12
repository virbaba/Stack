import java.util.*;
import java.io.*;

public class Solution {
  public static int findMinimumCost(String str) {
    // Write your code here
    Stack<Character> st = new Stack<>();
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (st.isEmpty()) {
        st.push(c);
      } else {
        if (c == '}') {
          if (st.peek() == '{') {
            st.pop();
            continue;
          }
        }
        st.push(c);
      }
    }

    while (st.size() >= 2) {
      char c1 = st.pop();
      char c2 = st.pop();

      if (c1 == '}' && c2 == '}')
        count += 1;
      else if (c1 == '{' && c2 == '{')
        count += 1;
      else if (c1 == '{' && c2 == '}')
        count += 2;

    }

    return (st.isEmpty()) ? count : -1;

  }
}
