package patterns.Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Digraph {

    private int v;
    private LinkedList<Integer> adj[];

    public Digraph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w)  { adj[v].add(w); }

    public int V(){
        return v;
    }

    public Digraph reverse(){
        Digraph g = new Digraph(v);
        for (int i = 0; i < v; i++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> j =adj[i].listIterator();
            while(j.hasNext())
                g.adj[j.next()].add(i);
        }
        return g;
    }

    public List<Integer> adjs(int v){
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> j =adj[v].listIterator();
        while(j.hasNext())
            result.add(j.next());

        return result;
    }
}
