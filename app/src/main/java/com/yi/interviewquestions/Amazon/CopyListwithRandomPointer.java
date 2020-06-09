package com.yi.interviewquestions.Amazon;

import java.util.HashMap;

public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node DummyNode = new Node(0);
        Node pointer = DummyNode;
        HashMap<Node,Node> hm = new HashMap<Node,Node>();

        while(head!=null){
            Node temp = null;
            if(hm.containsKey(head)){
                temp = hm.get(head);
            }else{
                temp = new Node(head.val);
                hm.put(head, temp);
            }

            if(head.random!=null){
                if(hm.containsKey(head.random)){
                    temp.random = hm.get(head.random);
                }else{
                    temp.random = new Node(head.random.val);
                    hm.put(head.random, temp.random);
                }
            }


            pointer.next = temp;
            pointer = pointer.next;
            head = head.next;
        }

        return DummyNode.next;
    }
}
