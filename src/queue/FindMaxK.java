package queue;

import util.Log;

import java.util.*;

public class FindMaxK {

    private PriorityQueue<Integer> priorityQueue;
    private int k;

    public FindMaxK(int k) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>();
    }

    public static void main(String[] args) {
        FindMaxK findMaxK = new FindMaxK(3);

        int[] numbers = {3, 10, 1000, -99, 4, 100};

        findMaxK.add(3);
        findMaxK.add(10);

        List<Integer> topk = findMaxK.topk();
        Log.d(topk.toString());
    }

    public void add(int num) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(num);
        } else {
            int top = priorityQueue.peek();
            if (top < num) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
    }

    public List<Integer> topk() {

        List<Integer> result = new LinkedList<>();

        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2- o1;
            }
        });
        return result;
    }

}
