package Array;

import java.util.*;
import java.util.stream.Collectors;

// Given 2 sorted arr: arr1 and arr2 of size m and n, find union.
// Union = distinct elements from both array. and they should be in ascending order.
public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,7,8,11};
        int[] arr2 = {2,3,4,4,6,9,11};

       // bruteForce(arr1.clone(), arr2.clone());
        optimal(arr1.clone(), arr2.clone());


    }

    public static void bruteForce(int[] arr1, int[] arr2) {
        /**
         * APPROACH:
         *          1. Using SET for unique elements.
         *          2. Using TreeSet for maintaining sorting order.
         *          TIME COMPLEXITY: O(n log n')+O(m log n')
         *          SPACE COMPLEXITY: O(n+m).
         */
        Set union = new TreeSet();

        // Adding arr1 to set.
        for(int i =0;i< arr1.length;i++) {
            union.add(arr1[i]);
        }

        // Adding arr2 to set.
        for(int i=0;i<arr2.length;i++) {
            union.add(arr2[i]);
        }

        for(final var x: union) {
            System.out.println(x);
        }
    }

    public static void optimal(int[] arr1, int[] arr2) {
        /**
         * APPROACH:
         *           1. 2 pointers set at the first index of each array.
         *           2. Compare based on the smaller value and put that value in the union.
         *           3. Proceed the respective pointer to the next position.
         *           4. Keep on doing this till we exhaust one array.
         *           5. Still, iterate over the remaining array, but the value should be compared
         *              between the values in the union array and the current array.
         */

        var union = new ArrayList<>();

        // initializing pointers.
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                // Check if our element already exists in union arr.
                if (union.isEmpty() || (!union.get(union.size()-1).equals(arr1[i]))) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                // Check if our element already exists in union arr.
                if (union.isEmpty() || (!union.get(union.size()-1).equals(arr2[j]))) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        // If arr1 is not exhausted.
        while (i < arr1.length) {
            if (union.isEmpty() || (!union.get(union.size()-1).equals(arr1[i]))) {
                union.add(arr1[i]);
            }
            i++;
        }

        // If arr2 is not exhausted.
        while (j < arr2.length) {
            if (union.isEmpty() || (!union.get(union.size()-1).equals(arr2[j]))) {
                union.add(arr2[j]);
            }
            j++;
        }

        for (var x : union) {
          System.out.print(x+ " ");
        }
    }
}
