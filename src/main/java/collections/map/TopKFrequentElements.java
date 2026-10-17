package collections.map;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k =2;
        int [] topFrequentElements = findTopFrequentElements(nums, k);
        System.out.println(Arrays.toString(topFrequentElements));
    }

    private static int[] findTopFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> freqOfElement = new LinkedHashMap<>();
        for (int num : nums){
            freqOfElement.put(num, freqOfElement.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a, b) -> Integer.compare(freqOfElement.get(a), freqOfElement.get(b)));
        for(Integer num : freqOfElement.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(num);
            } else if (freqOfElement.get(num)>freqOfElement.get(priorityQueue.peek())) {
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }
        int[]  result = new int[k];
        for (int i=0; i<k;i++){
            result[i]= priorityQueue.poll();
        }
        return result;
    }
}
