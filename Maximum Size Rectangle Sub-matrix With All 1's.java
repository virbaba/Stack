import java.util.*;
public class Solution {

	public static int[] nextSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] next = new int[arr.length];
        next[n-1] = n;
        st.push(n);
        for(int i = n - 1; i >= 0; i--){
            while(st.size() > 1 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            next[i] = st.peek();
            st.push(i);

        }
        return next;
    }
    public static int[] preSmaller(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] pre = new int[arr.length];
        pre[0] = -1;
        st.push(-1);
        for(int i = 0; i < arr.length; i++){
            while(st.size() > 1 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            pre[i] = st.peek();
            st.push(i);

        }
        return pre;
    }

	public static int maxAreaOfHistogram(int[] heights, int[] next, int[] pre){
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;

        for(int i = 0; i < n; i++){
            int wid = next[i] - pre[i] - 1;
            int currArea = heights[i] * wid;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
	public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
		// Write your code here.
		for(int r = 1; r < n; r++){
            for(int c = 0; c < m; c++){
                if(mat[r][c] != 0){
                    mat[r][c] = mat[r][c] + mat[r-1][c];
                }
            }
        }

        int maxArea = Integer.MIN_VALUE;
       for(int[] arr : mat){

           int[] next = nextSmaller(arr);
           int[] pre = preSmaller(arr);

           maxArea = Math.max(maxArea, maxAreaOfHistogram(arr, next, pre));
       }

       return maxArea;
	}
}
