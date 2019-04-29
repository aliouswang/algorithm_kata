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

    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        List<Integer> resultList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

            tryOfferIntoDeque(arrayDeque, nums[i], k, i + 1);
            if (i >= k - 1) {
                resultList.add(arrayDeque.peekFirst());
            }
        }

        return resultList;
    }

    private void tryOfferIntoDeque(ArrayDeque<Integer> arrayDeque, int number, int k, int index) {
        if (index >= k) {
            arrayDeque.pollFirst();
            while (!arrayDeque.isEmpty()) {
                int first = arrayDeque.peekFirst();
                if (first <= number) {
                    arrayDeque.pollFirst();
                } else {
                    break;
                }
            }
            arrayDeque.offer(number);
            return;
        } else {
            if (arrayDeque.isEmpty()) {
                arrayDeque.offer(number);
                return;
            }
            int first = arrayDeque.peekFirst();
            if (number > first) {
                arrayDeque.clear();
                arrayDeque.offer(number);
            } else {
                arrayDeque.offer(number);
            }
        }
    }

}
