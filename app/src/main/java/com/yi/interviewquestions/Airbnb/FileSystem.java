package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {

    public class TriTree{
        List<TriTree> next;
        String path;
        int msg;

        public TriTree(List<TriTree> next,String path){
            this.next = next;
            this.path = path;
        }

    }

    public class Solution{

        TriTree root;
        public void Solution(){
            root = new TriTree(new ArrayList<TriTree>(),null);
        }

        public boolean create(String path, int msg){
            TriTree pointer = root;
            //a b c
            String[] paths = path.split("/");
            for(int i = 0; i< paths.length; i++){
                if(!paths[i].equalsIgnoreCase("")) {
                    if (pointer.next.size() == 0 && i == paths.length - 1) {
                        TriTree temp = new TriTree(new ArrayList<TriTree>(), paths[i]);
                        temp.msg = msg;
                        pointer.next.add(temp);
                    } else {
                        boolean findElement = false;
                        for (int j = 0; j < pointer.next.size(); j++) {
                            if (pointer.next.get(j).path.equalsIgnoreCase(paths[i])) {
                                pointer = pointer.next.get(j);
                                findElement = true;
                                break;
                            }
                        }
                        if (!findElement && i != paths.length - 1) {
                            new Exception();
                            return false;
                        }

                        if(findElement && i == paths.length - 1){
                            return false;
                        }

                        if (!findElement) {
                            TriTree temp = new TriTree(new ArrayList<TriTree>(), paths[i]);
                            temp.msg = msg;
                            pointer.next.add(temp);
                        }
                    }
                }
            }

            return true;

        }

        public int get(String path){
            String[] paths = path.split("/");
            TriTree pointer = root;

            for(int i = 0; i< paths.length; i++){
                if(!paths[i].equalsIgnoreCase("")) {
                    boolean findElement = false;
                    for (int j = 0; j < pointer.next.size(); j++) {
                        if (pointer.next.get(j).path.equalsIgnoreCase(paths[i])) {
                            pointer = pointer.next.get(j);
                            findElement = true;
                            break;
                        }
                    }

                    if (!findElement) {
                        new Exception();
                        return -1;
                    }
                }
            }

            return pointer.msg;
        }

        public boolean set(String path, int msg){
            String[] paths = path.split("/");
            TriTree pointer = root;

            for(int i = 0; i< paths.length; i++){
                if(!paths[i].equalsIgnoreCase("")) {
                    if (pointer.next.size() == 0) {
                        return false;
                    } else {
                        boolean findElement = false;
                        for (int j = 0; j < pointer.next.size(); j++) {
                            if (pointer.next.get(j).path.equalsIgnoreCase(paths[i])) {
                                pointer = pointer.next.get(j);
                                findElement = true;
                                break;
                            }
                        }
                        if (!findElement) {
                            new Exception();
                            return false;
                        }
                    }
                }
            }
            pointer.msg = msg;

            return true;
        }

    }
}
