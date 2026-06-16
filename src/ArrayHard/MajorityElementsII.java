package ArrayHard;

import java.util.HashMap;
import java.util.HashSet;

// Given an array of integers of size n, remove all elements > n/3 times.
public class MajorityElementsII {
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 1, 3,1, 1, 3,0,3,0,3,3};
        brute(nums.clone());
        System.out.println("***************");
        better(nums.clone());
        System.out.println("***************");
        optimal(nums.clone());
    }

    public static void brute(int[] arr) {
        /**
         * APPROACH:
         *          IMPORTANT NOTE: For n/3 threshold, at max, we can have 2 elements occurring > n/3.
         *          eg. n = 6, n/3 = 2.
         *              I can have element 1: appearing 3 times (>n/3)
         *              I can have element 2: appearing 3 times (n>3)
         *              But not anymore. since that would make the count > n which is not possible.
         *
         *          1. Compare the element such that it is > n/3.
         *             Store it in a set to avoid duplicates.
         *
         *          2. Time Complexity: O(N2) + O(N) ~ O(N2)
         *             Space Complexity: O(1)
         */
        int thresholdLimit = arr.length/3;
        int count;

        var set = new HashSet<Integer>();

        for(int i=0;i<arr.length;i++) {
            count=0;
            for(int j=0;j<arr.length;j++) {
                if(arr[i]==arr[j]) {
                    count++;
                }
            }

            if(count>thresholdLimit) {
                set.add(arr[i]);
            }

            // If set has already 2 elements because n/3 can have atmost 2 elements only, break.
            if(set.size() == 2) {
                break;
            }

        }

        for(var x: set) {
            System.out.println(x);
        }
    }

    public static void better(int[] arr) {
        /**
         * APPROACH:
         *          1. Put elements and its count in map.
         *          2. Check for count if threshold limit > n/3.
         */
        int thresholdLimit = arr.length/3;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        // Look up the value occurring > threshold limit.
        for(final var entrySet: map.entrySet()) {
            if(entrySet.getValue()>thresholdLimit) {
                 System.out.println(entrySet.getKey());
            }
        }

    }

    public static void optimal(int[] arr) {

        int thresholdLimit = arr.length/3;
        /**
         * MORES'S VOTING ALGORITHM: There are more of us.
         *
         * APPROACH:
         *          Since at most 2 elements can occur >n/3,
         *          We take 2 counter and 2 elements.
         *
         *          For every time the number is equal to element1/element2, we increase
         *          the respective count.
         *
         *          For other case, we decrease both count. However, when either one of them is 0,
         *          We pick the current element to be the potential candidate element BUT keeping the condition
         *          that the current element != element1/element2.
         *
         *          TIME COMPLEXITY: O(N)
         *          SPACE COMPLEXITY: O(1)
         */
        int element1=0, element2=0, count1=0, count2=0;

        for(int i=0;i<arr.length;i++) {
            // Take the first element to be potential candidate and increase count by 1 but make sure its unique
            // and not taken by other.
           if(count1 == 0 && arr[i]!=element2) {
               element1 = arr[i];
               count1 =1;
           }

           else if(count2 == 0 && arr[i]!=element1) {
               element2=arr[i];
               count2 = 1;
           }

           // If a match is found, increase counter.
           else if (arr[i]==element1) {
               count1++;
           }

           else if(arr[i]== element2) {
               count2++;
           }

           // Otherwise decrease counter and once it reaches 0, the current element becomes the potential candidate.
           else {
               count1--;
               count2--;
           }
        }

        // Manual check if the element1 and element2 are afterall our result( from potential-> actual) since, the condition
        // that count1>N/3 and count2>N/3 remains.
        count1=0;
        count2 = 0;
        for(int i=0;i<arr.length;i++) {
            if(element1 == arr[i]) {
                count1++;
            }

            else if(element2 == arr[i]) {
                count2++;
            }
        }

        if(count1>thresholdLimit) {
           System.out.println(element1);
        }

        if(count2>thresholdLimit) {
            System.out.println(element2);
        }
    }
}
