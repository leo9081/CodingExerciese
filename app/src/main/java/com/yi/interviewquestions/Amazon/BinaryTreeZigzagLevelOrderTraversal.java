package com.yi.interviewquestions.Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.offer(root);
        int lineCount = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> line = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(lineCount%2 == 0){
                    line.add(temp.val);
                }else{
                    line.add(0,temp.val);
                }
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
            lineCount++;
            result.add(line);
        }

        return result;
    }
}
