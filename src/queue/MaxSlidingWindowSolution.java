package queue;

import util.Log;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MaxSlidingWindowSolution {

    public static void main(String[] args) {
        MaxSlidingWindowSolution solution = new MaxSlidingWindowSolution();

//        int[] nums = {1,2,7,7,2,10,3,4,5};
//
//        [1,2,7,7,2,10,3,4,5]
//        2

        int[] nums = {1,2,7,7,2};

        List<Integer> result = solution.maxSlidingWindow(nums, 3);

        Log.d(result.toString());

    }

    private void inQueue(int[] nums, ArrayDeque<Integer> arrayDeque, int n) {
        while (!arrayDeque.isEmpty() && nums[arrayDeque.peekLast()] <= nums[n]) {
            arrayDeque.pollLast();
        }
        arrayDeque.offer(n);
    }

    private void outQueue(ArrayDeque<Integer> arrayDeque, int n) {
        if (arrayDeque.peekFirst() == n) {
            arrayDeque.pollFirst();
        }
    }

    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        List<Integer> resultList = new LinkedList<>();
        if (nums == null || nums.length == 0) return resultList;
        for (int i = 0; i < k-1; i++) {
            inQueue(nums, arrayDeque, i);
        }

        for (int i = k-1; i < nums.length; i++) {
            inQueue(nums, arrayDeque, i);
            resultList.add(nums[arrayDeque.peekFirst()]);
            outQueue(arrayDeque, i-k+1);
        }

        return resultList;
    }
}
