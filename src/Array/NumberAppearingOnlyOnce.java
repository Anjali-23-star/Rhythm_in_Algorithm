package Array;

import java.util.HashMap;
import java.util.Map;

// Given a non empty array of integer, every element appears twice except one. Find that one.
public class NumberAppearingOnlyOnce {
    public static void main(String[] args) {

        int[] arr = {4,1,2,9,4,1,2};

//        System.out.println(bruteForce(arr.clone()));
//        System.out.println(freqMap(arr.clone()));

      //  System.out.println(better(arr.clone()));

        System.out.println(optimal(arr.clone()));
    }

    public static int bruteForce(int[] arr) {
        /**
         * APPROACH:
         *           1. Pick up every element once and set it as target.
         *           2. Perform linear search in the array and count the occurence of target.
         *           3. if count==1, return target.
         *
         * TIME COMPLEXITY: O(N*N).
         * SPACE COMPLEXITY: O(1).
         */
        int target =0, count =0;

        for(int i=0;i<arr.length;i++) {
            target = arr[i];
            count = 0;

            for(int j=0;j<arr.length;j++) {
                if(target == arr[j]) {
                    count++;
                }
            }

            if(count==1) {
                return target;
            }
        }
        return -1;
    }

    public static int freqMap(int[] arr) {
        /**
         * APPROACH:
         *         1. We use hashing-> The size of hash array is maxelement+1. so index can go from 0 to max element.
         *         2. TIME COMPLEXITY: O(N)
         *            SPACE COMPLEXITY: O(M) where M=maximum element. Insufficient for large elements.
         */
        int result = 0, maxElement = arr[0];

        // Finding out the maximum element.
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>maxElement) {
                maxElement = arr[i];
            }
        }

        int freq[] = new int[maxElement+1];

        for(int i=0;i<arr.length;i++) {
            freq[arr[i]] += 1;
        }

        for(int i=0;i<freq.length;i++) {
            if(freq[i] == 1) {
               result = i;
            }
        }
        return result;
    }

    public static int better(int[] arr) {
        /**
         * APPROACH: We use a hashmap to look up the occurence of each element and pick the key
         *           whose value =1.
         */

        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int i =0;i<arr.length;i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            if(entry.getValue()==1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static int optimal(int[] arr) {

        /**
         * APPROACH:
         *          1. A^A=0 and 0^B=B. we use this trick.
         *          2. Time complexity: O(n)
         *             Space complexity: O(1).
         */
        int xor =0;

        for(int i=0;i<arr.length;i++) {
            xor^= arr[i];
        }

        return xor;
    }
}
