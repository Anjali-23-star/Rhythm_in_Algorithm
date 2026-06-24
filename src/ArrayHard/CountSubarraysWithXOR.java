package ArrayHard;

import java.util.HashMap;

// Given an array of integers A and an integer B find total number of subarrays having bitwise XOR
// of all elements equal to K.
public class CountSubarraysWithXOR {
    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 6, 4};
        System.out.println(optimal(arr.clone(), 6));
    }

    /**
     * APPROACH:
     *          It's a subarray problem: we will pick the prefix sum.
     *          However, since its XOR we are after, we will instead of summing, store running XOR's.
     *
     *          Our objective is to collect all sub arrays having P(current) ^ P(previous) = k.
     *
     *          1. We check if the current element xored K is already stored.
     *             If yes: then we have got the subarray.
     */
    public static int optimal(int[] arr, int k) {
        final var hashMap = new HashMap<Integer, Integer>();

        int xor=0, count=0;

        // We see the xor 0 to be exactly 1 time before starting.
        hashMap.put(0, 1);

        for(int i=0;i<arr.length;i++) {
            xor^=arr[i];

            int previous = k^xor;

            // If k exists.
            if(hashMap.containsKey(previous)) {
               count+=hashMap.getOrDefault(previous, 0);
            }

            hashMap.put(xor, hashMap.getOrDefault(xor, 0)+1);
        }

        return count;
    }
}
