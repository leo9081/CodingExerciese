package patterns.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetAllSCC {
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Digraph g = new Digraph(6);
        g.addEdge(1, 0);
        g.addEdge(0, 3);
        g.addEdge(2, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);

        KosarajuAlgorithm k = new KosarajuAlgorithm(g);

        for(int i = 0; i<k.result.size();i++){
            for(int j = 0; j<k.result.get(i).size(); j++){
                System.out.print(k.result.get(i).get(j));
            }
            System.out.println(" ");
        }
    }

    public static class KosarajuAlgorithm {

        Stack<Integer> s = new Stack<>();
        boolean[] visited;
        List<Integer> temp;
        List<List<Integer>> result = new ArrayList<>();

        public KosarajuAlgorithm(Digraph G) {
            visited=new boolean[G.V()];

            for(int i =0; i< visited.length;i++){
                visited[i] = false;
            }

            for(int i= 0; i< G.V();i++){
                if(!visited[i]) {
                    dfs(G, i);
                }
            }

            Digraph reverseG = G.reverse();

            for(int i =0; i< visited.length;i++){
                visited[i] = false;
            }

            while(!s.isEmpty()){
                int tmp = s.pop();
                temp = new ArrayList<>();
                if(!visited[tmp]) {
                    dfs2(reverseG, tmp);
                    result.add(temp);
                }
            }
        }

        public void dfs2(Digraph reverseG,int v){
            visited[v] = true;

            for(int i: reverseG.adjs(v)){
                if(!visited[i]){
                    dfs2(reverseG,i);
                }
            }
            temp.add(v);
        }

        public void dfs(Digraph G,int v){
            visited[v] = true;

            for(int i: G.adjs(v)){
                if(!visited[i]){
                    dfs(G,i);
                }
            }
            s.push(v);
        }
    }
}
