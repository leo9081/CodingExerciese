package com.yi.interviewquestions.Amazon;

import com.yi.interviewquestions.Facebook.Tree.TreeNode;

public class SubtreeofAnotherTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return false;
        if((s == null && t!=null )||(s!=null && t == null)) return false;
        if(s.val == t.val){
            if(isVailed(s,t)) return true;
        }

        boolean left = isSubtree(s.left,t);
        boolean right = isSubtree(s.right,t);

        return left || right;

    }

    public boolean isVailed(TreeNode s, TreeNode t){
        if((s == null && t!=null )||(s!=null && t == null)) return false;
        if(s == null && t == null) return true;
        if(s.val != t.val) return false;

        boolean left = isVailed(s.left, t.left);
        boolean right = isVailed(s.right, t.right);

        if(left && right) return true;
        else return false;
    }
}
