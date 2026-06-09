package ArrayMedium;

import java.util.ArrayList;

// Given an array of integers and an integer K , return the total number of subarrays whose sum equals K.
public class SubArraySumEqualsK {
    public static void main(String[] args) {

        int[] arr = {3,1,2,4};
        int target = 6;
        brute(arr,target);
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
}
