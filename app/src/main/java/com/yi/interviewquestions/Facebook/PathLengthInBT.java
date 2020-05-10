package com.yi.interviewquestions.Facebook;

class TreeNode{
    int value;
    TreeNode leftNode;
    TreeNode rightNode;
    public TreeNode(int value){
        this.value = value;
    }
}

public class PathLengthInBT {

    public int pathLength(TreeNode root, TreeNode a, TreeNode b){
        if(root == null) return 0;
        //Find LCA
        TreeNode subRoot = LCA(root, a, b);

        //use LCA as Root find D2a, D2b
        int D2a = D2node(subRoot,a)-1;
        int D2b = D2node(subRoot,b)-1;

        //return sum
        return D2a+D2b;
    }

    public int D2node(TreeNode root, TreeNode d){
        if(root == null) return 0;
        if(root.value == d.value) return 1;

        int left = D2node(root.leftNode, d);
        int right = D2node(root.rightNode,d);

        if(left>0) return ++left;
        if(right >0)return ++right;
        return 0;
    }


    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b){
        if(root== null || root.value == a.value || root.value == b.value){
            return root;
        }

        TreeNode left = LCA(root.leftNode,a,b);
        TreeNode right = LCA(root.rightNode,a,b);

        if(left != null && right != null){
            return root;
        }else if(left != null) {
            return left;
        }else  if(right !=null) {
            return right;
        }else{
            return null;
        }

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        /*root.leftNode = new TreeNode(10);
        root.rightNode = new TreeNode(7);
        root.leftNode.leftNode = new TreeNode(32);
        root.leftNode.rightNode = new TreeNode(1);
        root.rightNode.rightNode = new TreeNode(8);*/

        PathLengthInBT pathLengthInBT = new PathLengthInBT();
        int resutl = pathLengthInBT.pathLength(root,new TreeNode(5),new TreeNode(5));
        System.out.println(resutl);
    }


}
