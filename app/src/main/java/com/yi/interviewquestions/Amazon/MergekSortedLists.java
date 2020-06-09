package com.yi.interviewquestions.Amazon;


import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class NumComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b){
            return a.val-b.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode Dummy = new ListNode();
        ListNode pointer = Dummy;
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new NumComparator());

        for(int i = 0 ;i < lists.length; i++){
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }

        while(!pq.isEmpty()){
            ListNode temp = pq.poll();

            if(temp.next!=null){
                pq.offer(temp.next);
            }

            pointer.next = temp;
            pointer = pointer.next;
        }

        return Dummy.next;

    }
}
