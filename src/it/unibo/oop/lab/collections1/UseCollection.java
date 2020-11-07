package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
    private static final int TO_MS = 1_000_000;
	private static final int ARRAY_LIST_CAPACITY = 1_000; 
	private static final int ELEMS_TO_ADD = 100_000;
	private static final int ELEMS_TO_READ = 100_000;

    private UseCollection() {
    }
    
    private static int getLastIndexList(List<?> list) {
    	return list.size() - 1;
    }
     
    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	final List<Integer> aList = new ArrayList<>(ARRAY_LIST_CAPACITY);
    	for (int i = 0; i <= ARRAY_LIST_CAPACITY; i++) {
    		aList.add(i + ARRAY_LIST_CAPACITY);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	final List<Integer> lList = new LinkedList<Integer>(aList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	final int tmp = aList.get(getLastIndexList(aList));
    	aList.set(getLastIndexList(aList), aList.get(0));
    	aList.set(0, tmp);
    	    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (Integer i : aList) {
    		System.out.println(i);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
        long timeArrayList = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_ADD; i++) {
        	aList.add(0, i);
        }
        timeArrayList = System.nanoTime() - timeArrayList;

        long timeLinkedList = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_ADD; i++) {
        	lList.add(0, i);
        }        
        timeLinkedList = System.nanoTime() - timeLinkedList;
        
        System.out.println("Adding " + ELEMS_TO_ADD + " elements as first element of the collection:\n " 
                + "\tArrayList=" + timeArrayList + "ns (" + timeArrayList / TO_MS + "ms)\n"
                + "\tLinkedList=" + timeLinkedList + "ns (" + timeLinkedList / TO_MS + "ms)" );
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        long timeArrayList1 = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_READ; i++) {
        	aList.get(aList.size() / 2);
        }
        timeArrayList1 = System.nanoTime() - timeArrayList1;

        long timeLinkedList1 = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_READ; i++) {
        	lList.get(lList.size() / 2);
        }
        timeLinkedList1 = System.nanoTime() - timeLinkedList1;
        
        System.out.println("Reading " + ELEMS_TO_READ + " elements whose position is in the middle of the collection:\n " 
        		+ "\tArrayList=" + timeArrayList1 + "ns (" + timeArrayList1 / TO_MS + "ms)\n"
                + "\tLinkedList=" + timeLinkedList1 + "ns (" + timeLinkedList1 / TO_MS + "ms)" );
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        
        final Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 972_005_000L);
        map.put("Antarctica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);

        /*
         * 8) Compute the population of the world
         */
       
        Long worldPopulation = 0L;
        for (final Long p : map.values()) {
        	worldPopulation += p;
        }
        System.out.println("World population=" + worldPopulation);
    }
}
