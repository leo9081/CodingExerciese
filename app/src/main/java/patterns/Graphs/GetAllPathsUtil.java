package patterns.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetAllPathsUtil {

    public void getAllPathBFS(List<List<Integer>> input, int start, HashMap<Integer, List<List<Integer>>> map){

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        while(!q.isEmpty()){
            int parent = q.poll();
            List<Integer> children = input.get(parent);

            for(Integer child: children){
                q.offer(child);
                List<List<Integer>> parentList = map.get(parent);
                List<List<Integer>> childList = map.get(child);

                if(parentList.isEmpty()){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(parent);
                    temp.add(child);
                    childList.add(temp);
                }else{
                    for(List<Integer> l: parentList) {
                        List<Integer> temp = new ArrayList<>();
                        temp.addAll(l);
                        temp.add(child);
                        childList.add(temp);
                    }
                }
            }

        }
    }

    //All paths from u to d
    public void getAllPathRe(ArrayList<Integer>[] adjList, Integer u, Integer d,
                             boolean[] isVisited, List<Integer> localPathList, List<List<Integer>> result) {

        isVisited[u] = true;

        if(u.equals(d)){
            result.add(localPathList);
            isVisited[u] = false;
            return;
        }

        for(Integer i: adjList[u]){
            if(!isVisited[i]){

                localPathList.add(i);
                getAllPathRe(adjList,i,d,isVisited,localPathList,result);
                localPathList.remove(i);

            }
        }

    }

}
