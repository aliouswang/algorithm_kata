package queue;

import util.Log;

import java.util.*;

public class TopKFrequenceWordsSolution {

    public static void main(String[] args) {
        String[] words = {"yes", "lint", "code",
                "yes", "code", "baby",
                "you", "baby", "chrome",
                "safari", "lint", "code",
                "body", "lint", "code"};
        String[] results = new TopKFrequenceWordsSolution().topKFrequentWords(words, 4);

        Log.d(Arrays.toString(results));
    }

    HashMap<String, Integer> wordMap = new HashMap<>();
    PriorityQueue<String> priorityQueue;
    public String[] topKFrequentWords(String[] words, int k) {

        if (k == 0) {
            String[] empty = new String[] {};
            return empty;
        }

        // build word map.
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                int cur = wordMap.get(word);
                wordMap.put(word, cur + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        priorityQueue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int k1 = wordMap.get(o1);
                int k2 = wordMap.get(o2);
//                return k2 - k1;
                if (k1 != k2) {
                    return k1 - k2;
                } else {
                    return o2.compareTo(o1);
                }
            }
        });

        for (Map.Entry<String, Integer> entity : wordMap.entrySet()) {
            String key = entity.getKey();
            Integer value = entity.getValue();
            if (priorityQueue.size() < k) {
                priorityQueue.offer(key);
            } else {
                int min = wordMap.get(priorityQueue.peek());
                if (min < value || (min == value && key.compareTo(priorityQueue.peek()) < 0)) {
                    priorityQueue.poll();
                    priorityQueue.offer(key);
                }
            }
        }

//        LinkedList<String> keys = new LinkedList<>();
        String[] arrays = new String[k];

        Iterator<String> iterator = priorityQueue.iterator();
        int index = 0;
        while (iterator.hasNext()) {
//            keys.add(iterator.next());
            arrays[index++] = iterator.next();
        }

//        Collections.sort(keys, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int k1 = wordMap.get(o1);
//                int k2 = wordMap.get(o2);
//                return k2 - k1;
//            }
//        });

        Arrays.sort(arrays, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int k1 = wordMap.get(o1);
                int k2 = wordMap.get(o2);
                if (k1 != k2) {
                    return k2 - k1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        return arrays;

    }

}
