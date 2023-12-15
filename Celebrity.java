import java.util.* ;
import java.io.*; 

	
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
		Stack<Integer> st  = new Stack<>();
		for(int i = 0; i < n; i++){
			st.push(i);
		}

		while(st.size() > 1){
			int p1 = st.pop();
			int p2 = st.pop();

			if(Runner.knows(p1, p2))
				st.push(p2);
			else
				st.push(p1);
		}

		boolean celebrity = true;
		int c = st.pop();
		for(int i = 0; i < n; i++){
			if(i == c)
				continue;
			if(Runner.knows(c, i)){
				celebrity = false;
				break;
			}
				

			if(!Runner.knows(i, c)){
				celebrity = false;
				break;
			}
				
		}

		return (celebrity)? c: -1;
		
    }
}
