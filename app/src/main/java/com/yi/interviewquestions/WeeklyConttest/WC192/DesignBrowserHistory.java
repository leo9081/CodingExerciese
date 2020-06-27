package com.yi.interviewquestions.WeeklyConttest.WC192;

public class DesignBrowserHistory {
    class BrowserHistory {
        class Node{
            Node pre;
            Node next;
            String value;
            public Node(String value){
                this.value = value;
            }
        }
        Node home;
        Node pointer;
        public BrowserHistory(String homepage) {
            home = new Node(homepage);
            pointer = home;
        }

        public void visit(String url) {
            Node temp = new Node(url);
            pointer.next = temp;
            temp.pre = pointer;
            pointer  = pointer.next;
            temp.next = null;
        }

        public String back(int steps) {
            while(steps > 0 && pointer != home){
                pointer = pointer.pre;
                steps--;
            }

            return pointer.value;
        }

        public String forward(int steps) {
            while(steps>0 && pointer.next!=null){
                pointer = pointer.next;
                steps--;
            }
            return pointer.value;
        }
    }

}
