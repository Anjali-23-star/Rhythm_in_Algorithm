package ArrayMedium;

import java.util.ArrayList;
import java.util.Collections;

// Find leaders in array. which simply means all the elements which are higher than all the elements succeeding it.
// [10,22,12,3,0,6] => 22,12,6.
public class LeadersInArray {
    public static void main(String[] args) {

        int[] arr= {10,22,12,3,0,6};
        brute(arr.clone());
        optimal(arr.clone());
    }

    public static void brute(int[] arr) {
        /**
         * APPROACH:
         *          1. Simply iterate picking up each element and comparing it with the subsequent elements.
         *          2. Fail fast: If at any point the picked element is smaller than the rest, break out of it.
         *
         *          TIME COMPLEXITY: O(N2)
         *          SPACE COMPLEXITY: O(1).
         */
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            flag = true;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] < arr[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.print(arr[i] + " ");
            }
        }
    }
        public static void optimal(int[] arr) {
            /**
             * APPROACH:
             *           The idea is-> the leader should be greater than the maximum of the
             *                         rest of the elements.
             *           1. We start from the last .
             *           2. We check if our picked elemnent> maximum element(subsequent elements)
             *              IF YES? Picked Element = leader.
             *              MAX ELEMENT = Picked Element.
             *
             *              IF NO? Ignore and move.
             *
             *           TIME COMPLEXITY:O(N)
             *           SPACE COMPELXITY: O(N)
             */
            int maxElement= Integer.MIN_VALUE;
            final var arrayList = new ArrayList<>();

            for(int i=arr.length-1;i>=0;i--) {
                if(arr[i]>maxElement) {
                    arrayList.add(arr[i]);

                    maxElement=arr[i];
                }
        }

            // reversing the list to maintain order.
            Collections.reverse(arrayList);
            System.out.print(arrayList);
    }
}
