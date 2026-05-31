package ArrayMedium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of n integers - Return the length of the longest sequence of consecutive integers.
 * The integers in this seq can appear in any order.
 *
 * eg. [100, 4, 200, 1, 3, 2] => Ans = 4 because [1,2,3,4].
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int[] arr1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] arr2 = {102, 4, 100, 1, 101, 3, 2, 1, 1, 1};

        System.out.println(brute(arr.clone()));
        System.out.println(better(arr1.clone()));
        System.out.println(optimal(arr2.clone()));
    }

    public static int brute(int[] arr) {
        /**
         * APPROACH:
         *           1. Pick an element.
         *           2. Search target = element+1 in the whole array.
         *              The len becomes count++
         *           3. If found: increment target by 1.
         *              Keep on increasing length .
         *           4. Find the max length.
         *
         *           TIME COMPLEXITY: O(N2)
         *           SPACE COMPLEXITY: O(1)
         */
    int count, len=0,target;
        for(int i=0;i<arr.length;i++) {
            count=1;
            target = arr[i]+1;

            while(linearSearch(arr, target)) {
                count++;
                target++;
            }

            len = Math.max(count, len);
        }
    return len;
    }

    // A helper method for linear search.
    public static boolean linearSearch(int[] arr, int target) {
        for(int i=0;i<arr.length;i++) {
            if(target==arr[i]) {
                return true;
            }
        }
        return false;
    }

    public static int better(int[] arr) {
        /**
         * APPROACH:
         *           1. We sort the array so we have consecutive numbers in array and can pick out the preceeding element.
         *           2. We take a var last smallest which captures the element preceding the current element.
         *           3. If the last element which is arr[i]-1, exists, then the current element arr[i] belongs to the chain of consecutive element.
         *                                                              -- increase the lenght of sub array by 1.
         *                                                              -- make the last smallest to be the current element arr[i].
         *           4. If the last element doesn't exists for the current element, then that element doesn't belong to our sequence.
         *                                                              -- make the count of sub array to 1 again since its a start of new sequence.
         *                                                              -- make the last sum to be the current element.
         *
         *            TIME COMPLEXITY: SORTING+ITERATION -> O(NlogN)+O(N) ~ O(NlogN)
         *            SPACE COMPLEXITY: O(1)
         */
        int lastSmallest=Integer.MIN_VALUE;
        int count=0, longest=0;

        // Sort first to place the elements together.
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++) {
            int target=arr[i]-1;

            if(target != lastSmallest) {
                // This element is not a part of our subarray, okay, make it the last smallest.
                lastSmallest = arr[i];
                count=1;
            }
            // Ignoring the duplicates.
            else if(i!=0 && arr[i]==arr[i-1]) {
                continue;
            }
            else {
                //So, arr[i] is a part of chain because its predesssor exists.
                count++;
                lastSmallest = arr[i];
            }
            longest=Math.max(longest, count);
        }

        return longest;
    }

    public static int optimal(int[] arr) {
        /**
         * APPROACH:
         *          1. Store the elements in SET dataset.
         *          2. Now, the intution is to get the elements which are start of the chain.
         *             - Check if for every element i
         *                 if i-1 exists? drop the element, move to next
         *                 otherwise
         *                 'i' is the start of the chain.
         *
         *            The idea is that if for any element there exists element-1, then that element is not
         *            our start of chain.
         *          3. Once you find the start, then simply look for consecuent order: i+1, i+2 etc.
         *             And incremnt count.
         *
         *             This reduces our complexity because we are just picking the start of the chain.
         *
         *             TIME COMPLEXITY: O(N)+O(N)+O(1) ~ O(N)
         *             SPACE COMPLEXITY: O(N)
         */
        int count = 0, len=0;

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++) {
            set.add(arr[i]);
        }

        for(var x: set) {
            count=0;
            if(!set.contains(x-1)) {
                count+=1;
                while(set.contains(x+1)) {
                    count++;
                    x = x + 1;
                }
                }
                len = Math.max(len, count);
            }


        return len;
    }
}
