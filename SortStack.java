import java.util.* ;
import java.io.*; 
public class Solution {
	public static void insertAtPos(Stack<Integer> stack, int x){
		if(stack.isEmpty()){
			stack.push(x);
			return;
		}
        if(x > stack.peek()){
            stack.push(x);
            return;
        }
		int ele = stack.pop();
		insertAtPos(stack, x);
		stack.push(ele);

	}
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		//Write your code here
		if(stack.size() == 1)
			return stack;
		
		int x = stack.pop();
		Stack<Integer> st = sortStack(stack);
		insertAtPos(st, x);

		return st;
	}
}

