package com.yi.interviewquestions.Facebook;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RobotRoomCleaner {

    //bfs not a solution
/*    int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    int rows;int cols;
    public void cleanRoom(Robot robot) {
        Stack<String> q = new Stack<>();
        int r = robot.row; int c = robot.col;
        rows = robot.room.length; cols = robot.room[0].length;
        Set<String> h = new HashSet<String>();
        int dirNum = 0;//0:up,1:left,2:down,3:right

        q.push(r+"#"+c);

        movement: while(!q.isEmpty()){
            robot.clean();
            String temp = q.pop();
            h.add(temp);
            for(int i = 0; i< dir.length; i++){
                int newr = temp.charAt(0)-'0'+dir[(dirNum + i)%4][0];
                int newc = temp.charAt(2)-'0'+dir[(dirNum + i)%4][1];
                //System.out.println(newr+" "+newc+" " + check(newr,newc) + " "+h.contains(newr+"#"+newc) + " " + robot.room[newr][newc]);
                if(check(newr,newc)
                        &&!h.contains(newr+"#"+newc)
                        &&robot.room[newr][newc]!=0){
                    System.out.println(newr+" "+newc);
                    q.push(newr+"#"+newc);
                }
            }

            int count = 0;

            if(!h.contains(temp.charAt(0)+dir[dirNum][0]+"#"+temp.charAt(2)+dir[dirNum][1]) && robot.move()){

                continue;
            }else{


                while(h.contains((temp.charAt(0)-'0'+dir[dirNum][0])+"#"+(temp.charAt(2)-'0'+dir[dirNum][1]))||!robot.move()){
                    if(count == 4){
                        //move back
                        robot.turnLeft();
                        robot.turnLeft();
                        robot.move();
                        robot.turnRight();

                        continue movement;
                    }
                    robot.turnLeft();
                    dirNum = (dirNum+1)%4;
                    count++;
                }
            }

        }
    }

    public boolean check(int row, int col){
        return row>=0 && col >=0 && row<rows &&col<cols;
    }*/
}
