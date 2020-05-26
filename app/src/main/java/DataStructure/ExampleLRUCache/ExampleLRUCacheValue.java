package DataStructure.ExampleLRUCache;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ExampleLRUCacheValue {

    //Only Value
    Set<Integer> cache;
    int capacity;

    public ExampleLRUCacheValue(int capacity){
        this.capacity = capacity;
        cache = new LinkedHashSet<>();
    }

    public void refer(int num){
        if(get(num) == false) put(num);
    }

    public boolean get(int num){
        if(!cache.contains(num)) return false;
        cache.remove(num);
        cache.add(num);
        return true;
    }

    public void put(int num){
        if(cache.size() == capacity){
            cache.remove(cache.iterator().next());
        }

        cache.add(num);
    }

    public void display(){
        for(Iterator<Integer> it = cache.iterator(); it.hasNext();){
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        ExampleLRUCacheValue ca = new ExampleLRUCacheValue(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }

}
