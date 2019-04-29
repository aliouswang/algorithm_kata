package queue;

import util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ArrayMedium {

    public static void main(String[] args) {
        ArrayMedium arrayMedium = new ArrayMedium();
        int[] arr = {4,5,1,3,2,6,0};
//        int[] arr = {0,-2,0,-3,-4,0,0,0};
        int[] result = arrayMedium.medianII(arr);

        Log.d(Arrays.toString(result));
    }

    private PriorityQueue<Integer> minHeap, maxHeap;

    public int[] medianII(int[] nums) {
        // write your code here
        int n = nums.length;
        int[] result = new int[n];
        maxHeap = new PriorityQueue<>(n, Collections.reverseOrder());
        minHeap = new PriorityQueue<>(n);

        for (int i = 0; i < n; i++) {
            if (maxHeap.size() == 0 || nums[i] < maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            balance();
            result[i] = maxHeap.peek();
        }
        return result;
    }

    private void balance() {
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        while (minHeap.size() < maxHeap.size() - 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

}
