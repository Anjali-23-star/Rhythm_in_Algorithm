import java.util.HashMap;
import java.util.Map;

public class FrequencyCountUsingHashmap {
    public static void main(String[] args) {
        int[] arr={4,2,56,88,2,4,5};
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        /**
         * SPACE COMPLEXITY: O(N) for processing each element.
         * TIME COMPLEXITY: O(N) for storing unique elements in the array.
         */
        for(int i=0;i<arr.length;i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i],0)+1);
        }

        // Iterating through the hashmap.
        for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey()+" occurs "+ entry.getValue());
        }

        

    }
}
