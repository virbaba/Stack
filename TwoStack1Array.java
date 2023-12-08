import java.util.* ;
import java.io.*; 
public class TwoStack {

	// Initialize TwoStack.
	int[] arr;
	int top1, top2, size;
	public TwoStack(int s) {
		// Write your code here
		arr = new int[s];
		top1 = -1;
		top2 = s;
		size = s;
	}

	// Push in stack 1.
	public void push1(int num) {
		// Write your code here
		top1++;
		if(top1 == top2){
			top1--;
			return;
		}
		arr[top1] = num;

	}

	// Push in stack 2.
	public void push2(int num) {
		// Write your code here
		top2--;
		if(top2 == top1){
			top2++;
			return;
		}
		arr[top2] = num;
	}

	// Pop from stack 1 and return popped element.
	public int pop1() {
		// Write your code here
		if(top1 == -1)
			return -1;
		int ele = arr[top1];
		top1--;
		return ele;
		
	}

	// Pop from stack 2 and return popped element.
	public int pop2() {
		// Write your code here
		if(top2 == size)
			return -1;
		int ele = arr[top2];
		top2++;
		return ele;
	}

}
