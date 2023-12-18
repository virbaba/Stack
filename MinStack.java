import java.util.*;

public class Solution {
    static class SpecialStack {
        Stack<Integer> st = new Stack<>();
        int min = Integer.MAX_VALUE;

        void push(int data) {
            // Implement the push() function.
            if (st.isEmpty()) {
                st.push(data * -1);
                min = data;
                return;
            }

            if (data >= min)
                st.push(data);
            else {
                int ele = (2 * min + data);
                st.push(ele * -1);
                min = data;
            }
        }

        void pop() {
            // Implement the pop() function.
            if (st.isEmpty())
                return;

            int ele = st.pop();
            if (ele < 0 && !st.isEmpty()) {
                ele = Math.abs(ele);
                min = (ele - min) / 2;
            }
            
        }

        int top() {
            // Implement the top() function.
            if (st.isEmpty())
                return -1;

            int ele = st.peek();

            if (ele < 0)
                return min;

            return ele;

        }

        int getMin() {
            // Implement the getMin() function.
            if (st.isEmpty())
                return -1;

            return min;
        }
    };
}
