package org.example;

import java.util.*;

public class _295_FindMedian {
    /*
    https://leetcode.com/problems/find-median-from-data-stream/description/
     */
    public static List<Double> runningMedian(List<Integer> list){
        List<Double> result = new ArrayList<>();


        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // tra nguoc lai gia tri mac dinh

        result.add(list.get(0) *1.0);
        maxHeap.add(list.get(0));


        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i);

            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(a);
            }
            else {
                maxHeap.add(a);
            }

            // validate: maxHeap < minHeap
            while (maxHeap.peek() > minHeap.peek()){
                int bigger = maxHeap.poll();
                int smaller = minHeap.poll();
                maxHeap.add(smaller);
                minHeap.add(bigger);
            }

            if (maxHeap.size() > minHeap.size()) {
                result.add(maxHeap.peek() * 1.0);
            }
            else {
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }

        return result;
    }
}
