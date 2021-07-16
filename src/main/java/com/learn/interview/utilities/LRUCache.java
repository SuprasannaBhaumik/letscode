package com.learn.interview.utilities;

import java.util.HashMap;
import java.util.Map;

/*LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
*/
public class LRUCache {

    private int capacity;

    private Map<Integer, MyCustomObject> myCache;

    //'CAsh'
    //'cas' 'ca'

    // 'c' -> like 'CA%' -> Pagable -> 50 10
    // 'c' -> 1000 list().stream().map().filter( word -> word.contains("")).collect(Collectir
    // (a,b ) -> {
    //
    // }

    private int counter;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        myCache = new HashMap<>(capacity);
    }

    public void put(int key, int value) {
        MyCustomObject myCustomObject = new MyCustomObject(key, value);


        if(myCache.isEmpty()) {
            myCustomObject.setCounter(1);
            myCache.put(key, myCustomObject);
        } else {

            if(myCache.size() == capacity) {

                myCache.values().stream().sorted();


            } else {
                myCache.put(key, myCustomObject);
            }
        }
    }


}
