package com.yi.interviewquestions.Facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
    class PQcomparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b){
            return a.val-b.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode Dummy = new ListNode(0);
        if(lists == null || lists.length == 0) return null;

        ListNode pointer = Dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,new PQcomparator());

        for(int i = 0; i< lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }

        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            pointer.next = temp;
            pointer = pointer.next;
            if(temp.next!=null) pq.add(temp.next);
        }

        return Dummy.next;

    }
}
