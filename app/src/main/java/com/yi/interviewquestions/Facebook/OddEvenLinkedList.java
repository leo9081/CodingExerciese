package com.yi.interviewquestions.Facebook;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode evendummy = new ListNode(0);
        ListNode evenPointer = head.next;
        evendummy.next = evenPointer;

        ListNode oddPointer = head;

        while(evenPointer != null && evenPointer.next!=null){

            oddPointer.next = evenPointer.next;
            oddPointer = oddPointer.next;

            if(oddPointer.next!=null){
                evenPointer.next = oddPointer.next;
                evenPointer = evenPointer.next;
            }else break;

        }
        if(evenPointer.next == null){
            oddPointer.next = null;
        }else if(oddPointer.next == null){
            evenPointer.next = null;
        }

        oddPointer.next = evendummy.next;

        return dummy.next;
    }
}
