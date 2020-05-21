package com.yi.interviewquestions.Facebook.Tree;

public class TreeNode {
    public int val;
    public TreeNode leftNode;
    public TreeNode rightNode;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          leftNode = left;
          rightNode = right;
      }
  }
