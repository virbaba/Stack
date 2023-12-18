import java.util.*;
import java.io.*;

public class NStack {
    // Initialize your data structure.
    int[] arr, top, nextSpot;
    int currSpot, size;

    public NStack(int N, int S) {
        // Write your code here.
        arr = new int[S];
        top = new int[N];
        nextSpot = new int[S];
        currSpot = 0;

        Arrays.fill(top, -1);

        for (int i = 1; i <= S; i++)
            nextSpot[i - 1] = i;

        nextSpot[S - 1] = -1;

    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack,
    // and false otherwise.
    public boolean push(int x, int m) {
        // Write your code here.
        if (currSpot == -1)
            return false;

        int index = currSpot;
        currSpot = nextSpot[index];
        arr[index] = x;
        nextSpot[index] = top[m - 1];
        top[m - 1] = index;
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise
    // returns the popped element.
    public int pop(int m) {
        // Write your code here.
        int index = top[m - 1];
        if (index == -1)
            return -1;

        int ele = arr[index];
        top[m - 1] = nextSpot[index];
        nextSpot[index] = currSpot;
        currSpot = index;

        return ele;

    }
}
