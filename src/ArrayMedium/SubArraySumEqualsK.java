package ArrayMedium;

import java.util.ArrayList;
import java.util.HashMap;

// Given an array of integers and an integer K , return the total number of subarrays whose sum equals K.
public class SubArraySumEqualsK {
    public static void main(String[] args) {

        int[] arr = {3,1,2,4};
        int target = 6;
        brute(arr,target);

        System.out.println(optimal(arr, target));
    }

    public static void brute(int[] arr, int k) {
        /**
         * APPROACH:
         *           1. We generate all the sub arrays.
         *           2. Using arraylist to store the sub arrays contributing to sum==k.
         *
         *           TIME COMPLEXITY: O(N2)
         *           SPACE COMPLEXITY: O(N)
         */
        int sum =0;
        ArrayList<Integer> elements = new ArrayList<>();

        for(int i=0;i<arr.length;i++) {
            sum =0;
            elements.clear();
            for(int j=i;j<arr.length;j++) {

                elements.add(arr[j]);
                sum+=arr[j];

                if(sum==k) {
                    System.out.println(elements);
                }
            }
        }
    }

    public static int optimal(int[] arr, int k) {
        /**
         * APPROACH:
         *           1. Using prefix sum. Storing [prefixsum, count of prefix sum].
         *              The count is to keep track of all the available sub arrays.
         *           2. Store the intital entry as [0, 1] because at the start, we have 0 as the prefix sum.
         *           3. Since sum = P[R]-P[L], we check if for our target k, is there a prefix sum P[current]-target in
         *              our map. If yes-> count of subarrays += 1.
         *               If no, add it to map, and count = 1.
         *
         *              NOTE if there exists another P[R] such that target-P[R]=existsign, then increase that count.
         *              So, we have all the possible sub arrays.
         *
         *              COMPELXITY: O(N).
         */
        int totalSubArrays = 0;
        int currentPrefixSum =0;

        HashMap<Integer, Integer> prefixSumCountMap = new HashMap<>();
        prefixSumCountMap.put(0,1);

        for(int num:arr) {
          currentPrefixSum+=num;

          int removeSum = currentPrefixSum-k;

          if(prefixSumCountMap.containsKey(removeSum)) {
              totalSubArrays += prefixSumCountMap.get(removeSum);
          }

          prefixSumCountMap.put(currentPrefixSum, prefixSumCountMap.getOrDefault(currentPrefixSum,0)+1);

        }

        return totalSubArrays;
    }
}
