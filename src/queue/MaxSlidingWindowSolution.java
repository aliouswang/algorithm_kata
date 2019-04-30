package queue;

import util.Log;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MaxSlidingWindowSolution {

    public static void main(String[] args) {
        MaxSlidingWindowSolution solution = new MaxSlidingWindowSolution();

        int[] nums = {1,2,7,7,2,10,3,4,5};
//
//        [1,2,7,7,2,10,3,4,5]
//        2

//        int[] nums = {1,2,7,7,2};

        List<Integer> result = solution.maxSlidingWindow(nums, 2);

        Log.d(result.toString());

    }

    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        List<Integer> resultList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

            if (i + 1 < k) {
                while (!arrayDeque.isEmpty()) {
                    int first = arrayDeque.peekFirst();
                    if (first <= nums[i]) {
                        arrayDeque.pollFirst();
                    } else {
                        break;
                    }
                }
                arrayDeque.offer(nums[i]);
            } else {
                while (arrayDeque.size() >= k) arrayDeque.pollFirst();
                // find next max
                if (arrayDeque.isEmpty()) {

                } else {
                    Iterator<Integer> integerIterator = arrayDeque.iterator();
                    int max = integerIterator.next();
                    int index = 0;
                    int maxIndex = 0;
                    while (integerIterator.hasNext()) {
                        int next = integerIterator.next();
                        if (max <= next) {
                            max = next;
                            maxIndex = index;
                        }
                        index++;
                    }
                    while (maxIndex > 0) {
                        arrayDeque.pollFirst();
                        maxIndex--;
                    }
                }
                while (!arrayDeque.isEmpty()) {
                    int first = arrayDeque.peekFirst();
                    if (first <= nums[i]) {
                        arrayDeque.pollFirst();
                    } else {
                        break;
                    }
                }
                arrayDeque.offer(nums[i]);

                resultList.add(arrayDeque.peekFirst());
            }
        }

        return resultList;
    }

//    private void tryOfferIntoDeque(ArrayDeque<Integer> arrayDeque, int number, int k, int index) {
//        if (index >= k) {
//            arrayDeque.pollFirst();
//            while (!arrayDeque.isEmpty()) {
//                int first = arrayDeque.peekFirst();
//                if (first <= number) {
//                    arrayDeque.pollFirst();
//                } else {
//                    break;
//                }
//            }
//            arrayDeque.offer(number);
//            return;
//        } else {
//            if (arrayDeque.isEmpty()) {
//                arrayDeque.offer(number);
//                return;
//            }
//            int first = arrayDeque.peekFirst();
//            if (number > first) {
//                arrayDeque.clear();
//                arrayDeque.offer(number);
//            } else {
//                arrayDeque.offer(number);
//            }
//        }
//    }

}
