import java.util.*;
import java.io.*;

public class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        st.push(-1);

        for (int i = n - 1; i >= 0; i--) {
            int e = arr.get(i);
            if (e <= st.peek()) {
                while (!st.isEmpty() && e <= st.peek()) {
                    st.pop();
                }
            }
            ans.add(0, st.peek());
            st.push(e);
        }
        return ans;

    }
}
