// Counting highest and lowest frequency using optimal approach.

import java.util.HashMap;
import java.util.Map;

public class HighestLowestFrequencyHashMap {
    public static void main(String[] args) {
        int[] arr={10,5,10,15,5};
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int maxValue=Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        int maxEle=-1,minEle=-1;

        /**
         * APPROACH: 1. We create map for frequency of elements.
         *           2. We pick the key and value and then compare the max and min values among value.
         * 
         * TIME COMPLEXITY: O(N) for iterating through the array+ O(K) for iterating to the hash map.
         *                  total=O(N)+O(k) ~ O(N).
         * SPACE COMPLEXITY: O(N) worst case for storing map. O(K) for non unique.
         */
        for(int i=0;i<arr.length;i++) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i],0)+1);
        }
        
        // Iterating through the hashmap.
        for(Map.Entry<Integer, Integer> entry: mpp.entrySet()) {
            // For maximum value.
            if(entry.getValue()>maxValue) {
                maxValue = entry.getValue();
                maxEle=entry.getKey();
            }
            
            // For minimum value.
            if(entry.getValue()<minValue) {
                minValue = entry.getValue();
                minEle = entry.getKey();
            }
        }

        System.out.println(maxEle+" occurs max times: "+ maxValue);
        System.out.println(minEle+" occurs min times: "+minValue);

    }
    
}
