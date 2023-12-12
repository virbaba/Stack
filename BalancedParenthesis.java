import java.util.* ;
import java.io.*; 

public class Solution {
	public static void solve(List<String> ans, String current, int open, int close, int n){
		if(current.length() == 2 * n){
			ans.add(current);
			return;
		}
		if(open < n)
			solve(ans, current+"(", open+1, close, n);
		if(close < open)
			solve(ans, current+")", open, close+1, n);
	}
	public static List<String> balancedParantheses(int n) {
		// Write your code here
		List<String> ans = new ArrayList<>();
		solve(ans, "", 0, 0, n);
		return ans;
	}
}
