package com.yi.interviewquestions.Airbnb;

import java.util.HashSet;
import java.util.List;

public class LowestCommonAncestor {

    public class solution{

        class TreeNode{
            TreeNode left;
            TreeNode right;
            String val;

            public TreeNode(String val){
                this.val = val;
                left = null;
                right = null;
            }
        }

        HashSet<Integer> usedLine = new HashSet<>();
        public String findCloestCity(List<List<String>> city, List<String> twoCitys){

            TreeNode root = new TreeNode(city.get(0).get(0));

            creatTree(city,root,0);

            TreeNode result = findLowestCommonAncestor(root,twoCitys.get(0),twoCitys.get(1));

            return result.val;
        }

        public void creatTree(List<List<String>> city,TreeNode root, int pos){
            if(pos == city.size()) return;
            System.out.println(root.val);

            if(city.get(pos).size()>=2 ) {

                root.left = new TreeNode(city.get(pos).get(1));
                System.out.println(root.left.val);
            }
            if(city.get(pos).size() == 3) {

                root.right = new TreeNode(city.get(pos).get(2));
                System.out.println(root.right.val);
            }


            for(int i = pos+1; i < city.size(); i++) {
                if(!usedLine.contains(i)) {
                    if (city.get(i).get(0).equalsIgnoreCase(root.left.val)) {
                        usedLine.add(i);
                        creatTree(city, root.left, i);
                    }
                    if (city.get(i).get(0).equalsIgnoreCase(root.right.val)) {
                        usedLine.add(i);
                        creatTree(city, root.right, i);
                    }
                }
            }
        }

        public TreeNode findLowestCommonAncestor(TreeNode root, String node1, String node2){
            if(root == null){
                return null;
            }
            if(root.val.equalsIgnoreCase(node1) || root.val.equalsIgnoreCase(node2)){
                return root;
            }

            TreeNode left = findLowestCommonAncestor(root.left, node1, node2);
            TreeNode right = findLowestCommonAncestor(root.right, node1, node2);

            if(left!=null && right!=null) return root;
            if(left!=null) return left;
            if(right != null) return right;
            else return null;
        }



    }
}
