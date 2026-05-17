package Array;

import java.util.HashMap;

/**
 * Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k.
 * If no such sub-array exists, return 0.
 */

public class SubArrayLength {
    public static void main(String[] args) {

        int[] arr = {1,2,2,1,3,1,1,6,1,1,1};
        int k = 15;

       // System.out.println(bruteForce(arr, 3));

        System.out.println(optimal(arr, 3));
    }

    public static int bruteForce(int[] arr, int k) {
        /**
         * APPROACH:
         *          1.  one index for keeping the starting index.
         *             Other for iterating from that index till the value of K is reached.
         *          2. Since, we have to find the longest sub-array, we compare it with the last
         *             length value and update the length to the Max(curr_length, previous_length).
         *          TIME COMPLEXITY: O(N*N)
         *          SPACE COMPLEXITY: O(1).
         */
        int i = 0,sum, length=0;

        while (i < arr.length) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == k) {
                    length = Math.max(length, j-i+1);

                }

            }
            i++;
        }

        return length;
    }

    public static int better(int[] arr, int k) {
        /**
         * APPROACH:
         *           1. In a hashmap, Key = the prefix sum upto the current index, value = index.
         *           2. For every sum==k, store the sub array length(since, we want the largest, so
         *                                                           we will compare it with others.)
         *           3. Now, at each point, we will also check if rem = currentsum-k, if 'rem' exists,
         *                                  then pick the index where it exists in the map.
         *                                  The sub array length = current_index-previous_index
         *              TIME COMPLEXITY: O(N), SPACE COMPLEXITY : O(N) for storing N sums.
         */
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen=0;

        for(int i=0;i<arr.length;i++) {
            sum +=arr[i];

            if(sum==k) {
                maxLen = i+1;
            }

            int rem = sum-k;

            if(map.containsKey(rem)) {
                int len = i-map.get(rem);

                maxLen=Math.max(maxLen,len);
            }

            // Store first occurence only.
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static int optimal(int[] arr, int k) {
        /**
         * APPROACH: SLIDING WINDOW. 2 Pointers; ONLY FOR NON-NEGATIVE.
         *              right: The expanding of window.
         *              left: shrinking the window for every sum>k.
         *
         *           1. The first pointer will be the starting index of subarray.
         *              The second pointer will traverse the array.
         *           2. We sum the array upto the jth elment.
         *              If sum==k, we store the max length.
         *              If at any point sum>k, we shrink the array. i.e. we move forward 'i'
         *              while removing the previous 'ith' index value from sum.
         *
         *              TIME COMPLEXITY: O(2N), SPACE COMPLEXITY: O(1).
         *                               Since left and right moves forward.
         */
        int left=0, sum=0, maxLen=0;

        for(int right =0; right<arr.length; right++) {
            sum+=arr[right];

            // While sum>k, keep on removing left.
            while(sum>k) {
                sum-=arr[left];
                left++;
            }

            if(sum==k) {
                maxLen = Math.max(maxLen, right-left+1);
            }
        }

        return maxLen;
    }
}
