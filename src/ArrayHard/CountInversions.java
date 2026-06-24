package ArrayHard;

import java.util.ArrayList;

// Given an array of N integers, count the inversion of the array(merge sort).
// arr=[5,3,2,4,1]
// inversions= left > right & i<j . eg (5,3) is an inversion because 5>3 but (4,2) cannot because 4 is on the right of the array.
public class CountInversions {
    public static int count;
    public static void main(String[] args) {

        int[] arr = {5,3,2,4,1};

        brute(arr);
        optimal(arr);
    }

    /**
     * APPROACH:
     *          Simply count for all i>j.
     *          TIME COMPLEXITY: O(N2)
     *          SPACE COMPLEXITY: O(1)
     */
    public static void brute(int[] arr) {
        int count=0;

        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i]>arr[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    /**
     * APPROACH:
     *           Idea is: If we have two sorted arrays:
     *           [2,3,5,6] and [2,2,24,4,8]
     *
     *           and we want to count inversions: i.e i<j and arr[i]>arr[j]
     *           1 pair: (3,2)
     *           now, since array is already sorted: then after 3 any number>3. so we simply
     *           add all the elements to count((5,2)(6,2)).
     *
     *           So, we ask if there is any algo which breaks array into 2 parts and is sorted.
     *           YES, merge sort.
     *
     *           so when arr[left]>arr[right], we count pairs.
     *
     *           TIME COMPLEXITY: O(nlogn)
     */
    public static void optimal(int[] arr) {
        divide(arr, 0, arr.length-1);


        System.out.println(count);
    }

    public static void divide(int[] arr, int low, int high) {

        if(low>=high) {
            return;
        }

        int mid = (low+high)/2;

        //left side.
        divide(arr, low, mid);

        // right side.
        divide(arr, mid+1, high);

        merge(arr, low, mid, high);

    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;

        final var temp = new ArrayList<Integer>();

        while(left<=mid && right<=high) {
            if(arr[left]<=arr[right]) {
                temp.add(arr[left]);

                left++;
            }

            else{
                temp.add(arr[right]);

                // count inversion
                count+=(mid-left+1);
                right++;
            }
        }

        while(left<arr[mid]) {
            temp.add(arr[left]);

            left++;
        }

        while(right<arr.length) {
            temp.add(arr[right]);

            right++;
        }

        for(int i= low;i<=high;i++) {
            arr[i]=temp.get(i-low);
        }

    }
}
