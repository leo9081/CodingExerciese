package com.yi.interviewquestions.Facebook.Tree;

import java.util.Stack;

public class BinarySearchTreeIterator {

    TreeNode root;
    TreeNode cur;
    Stack<TreeNode> s;

    public BinarySearchTreeIterator(TreeNode root) {
        this.s = new Stack<>();
        this.root = root;
        this.cur = root;
    }

    /** @return the next smallest number */
    public int next() {
        int result = -1;

        if(!s.isEmpty() || cur!=null){
            while(cur!=null){
                s.push(cur);
                cur = cur.leftNode;
            }
            cur = s.pop();
            result = cur.val;
            cur = cur.rightNode;
        }
        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!s.isEmpty() || cur != null);
    }
}
