package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}

public class ExampleTree {

/*    public int[] preorderTraversal(TreeNode root){

    }

    public int[] postorderTraversal(){

    }*/



    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public List<Integer> inorderTraversalDC(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        List<Integer> left = inorderTraversalDC(root.left);
        List<Integer> right = inorderTraversalDC(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

    public void inorderTraversalRecurtion(TreeNode root, List<Integer> result){
        if(root == null) return;

        inorderTraversalRecurtion(root.left, result);
        result.add(root.val);
        inorderTraversalRecurtion(root.right,result);
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i< size; i++) {
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(7);

        ExampleTree exampleTree = new ExampleTree();
        List<Integer> r = exampleTree.inorderTraversalDC(root);

        //List<Integer> r = new ArrayList<>();
        //exampleTree.inorderTraversalRecurtion(root,r);

        //Level Order traversal
        /*List<List<Integer>>  r = exampleTree.levelOrderTraversal(root);
        for(List<Integer> l: r){
            for(int i: l)
            System.out.println(i);
        }*/

        for(int i: r){
            System.out.println(i);
        }
    }

}
