package linkedlist;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode =  new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = new ListNode(8);

        ListNode listNode2 = new ListNode(2);

        ListNode merge = mergeTwoLists(listNode, listNode2);

        if (merge != null) {

        }


    }

    public int[] twoSum(int[] numbers, int target) {

        class Pair {
            int index;
            int value;

            public Pair(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        class PaiCompartor implements Comparator<Pair> {

            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        }

        // write your code here
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            pairs.add(new Pair(i, numbers[i]));
        }

        Collections.sort(pairs, new PaiCompartor());

        int left = 0;
        int right = pairs.size() - 1;

        while (left < right) {
            if (pairs.get(left).value + pairs.get(right).value > target) {
                right --;
            } else if (pairs.get(left).value + pairs.get(right).value < target) {
                left ++;
            } else {
                return new int[] {pairs.get(left).index, pairs.get(right).index};
            }
        }

        return new int[] {};
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode cur = head;
        ListNode pre = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode a = l1;
        ListNode b = l2;
        ListNode result = null;
        ListNode resultHead = null;
        while (a != null && b != null) {
            int val = 0;
            if (a.val > b.val) {
                val = b.val;
                b = b.next;
            } else {
                val = a.val;
                a = a.next;
            }
            ListNode newNode = new ListNode(val);
            if (result == null) {
                result = newNode;
                resultHead = result;
            } else {
                result.next = newNode;
                result = result.next;
            }
        }
        if (a == null) {
            result.next = b;
        } else {
            result.next = a;
        }
        return resultHead;
    }

}
