import java.util.Stack;

public class Solution {
    public static void insertAtBottom(Stack<Integer> stack, int x){
		if(stack.isEmpty()){
			stack.push(x);
			return;
		}
		int ele = stack.pop();
		insertAtBottom(stack, x);
		stack.push(ele);

	}
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
		if(stack.size() == 1)
			return;
		
		int x = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, x);
	}

}
