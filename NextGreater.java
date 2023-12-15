import java.util.*;
import java.io.*;

public class Solution {

	public static int[] nextGreater(int[] arr, int n) {
		// Write Your code here
		Stack<Integer> st = new Stack<>();
		st.push(Integer.MAX_VALUE);

		for (int i = n - 1; i >= 0; i--) {
			int e = arr[i];
			if (e >= st.peek()) {
				while (!st.isEmpty() && e >= st.peek()) {
					st.pop();
				}
			}
			if(st.peek() == Integer.MAX_VALUE)
				arr[i] = -1;
			else
				arr[i] = st.peek();
				
			st.push(e);
		}
		return arr;
	}

}
