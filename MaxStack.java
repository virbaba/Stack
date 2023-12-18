import java.util.*;

public class MaxStack {
	// Initialize MaxStack.
	Stack<Integer> st;
    int max;

    public MaxStack() {
        st = new Stack<>();
        max = Integer.MIN_VALUE;
    }

    public void specialPush(int data) {
        if (st.isEmpty()) {
            st.push(data);
            max = data;
        } else if (data <= max) {
            st.push(data);
        } else {
            st.push(2 * data - max);
            max = data;
        }
    }

    public int specialPop() {
        if (st.isEmpty()) {
            return -1; // Or throw an exception indicating stack underflow
        }

        int data = st.pop();
        if (data > max) {
            int prevMax = max;
            max = 2 * max - data;
            return prevMax;
        }
        return data;
    }

    public int specialTop() {
        if (st.isEmpty()) {
            return -1; // Or throw an exception indicating stack underflow
        }

        int ele = st.peek();
        if (ele > max) {
            return max;
        }
        return ele;
    }

    public int specialMax() {
        if (st.isEmpty()) {
            return -1; // Or throw an exception indicating stack underflow
        }

        return max;
    }
}
