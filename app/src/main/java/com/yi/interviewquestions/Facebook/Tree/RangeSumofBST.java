package com.yi.interviewquestions.Facebook.Tree;

import java.util.Stack;

public class RangeSumofBST {
        public int rangeSumBST(TreeNode root, int L, int R) {
            int sum = 0;
            Stack<TreeNode> s = new Stack<>();

            TreeNode cur = root;
            while(cur != null || !s.isEmpty()){
                while(cur != null){
                    s.push(cur);
                    cur = cur.leftNode;
                }

                cur = s.pop();
                if(cur.val >= L && cur.val <= R) sum += cur.val;
                if(cur.val > R) return sum;
                cur = cur.rightNode;
            }

            return sum;
        }
}
