package DataStructure;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ExampleTreeSet {
    //add,remove O(log n)
    //Either object synchronizing or wrapped by Collections.synchronizedSortedSet
    /*TreeSet ts = new TreeSet();
    Set syncSet = Collections.synchronizedSet(ts);*/

    public static void main(String[] args) {
        //new TreeSet()
/*        TreeSet<String> ts = new TreeSet<String>();
        ts.add("A");
        ts.add("C");
        ts.add("B");
        ts.add("E");
        ts.add("G");
        ts.add("F");
        ts.add("C");
        System.out.println(ts);
        System.out.println(ts.first());
        System.out.println(ts.last());
        System.out.println(ts.headSet("B"));
        System.out.println(ts.tailSet("B"));
        System.out.println(ts.ceiling("C"));

        System.out.println("");
        ts.descendingSet();
        Iterator<String> it = ts.descendingIterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
        System.out.println("");

        System.out.println(ts.floor("E"));
        System.out.println(ts.higher("E"));

        System.out.println(ts.pollFirst());
        System.out.println(ts.pollLast());
        System.out.println(ts);*/

        //new TreeSet(Comparator comp)
        TreeSet<Integer> ts = new TreeSet<Integer>(new tsComparator());
        ts.add(4);
        ts.add(6);
        ts.add(3);
        ts.add(1);
        ts.add(5);
        ts.add(6);
        ts.add(2);
        System.out.println(ts);


        //new TreeSet(Collection col)

    }

    static class tsComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
