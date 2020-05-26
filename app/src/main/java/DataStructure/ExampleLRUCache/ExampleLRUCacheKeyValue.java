package DataStructure.ExampleLRUCache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExampleLRUCacheKeyValue {
    Map<Integer,Integer> cache;
    int capacity;

    public ExampleLRUCacheKeyValue(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key,value);
        return value;
    }

    public void put(int key, int value) {
        if(get(key) == -1) add(key,value);
        else{
            cache.remove(key);
            cache.put(key,value);
        }
    }

    public void add(int key, int value){
        if(cache.size() == capacity){
            Iterator<Map.Entry<Integer,Integer>> it = cache.entrySet().iterator();
            Map.Entry<Integer, Integer> e = it.next();
            it.remove();
        }
        cache.put(key,value);
    }
}
