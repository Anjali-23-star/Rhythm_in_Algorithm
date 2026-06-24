package LearnSorting;

import java.util.ArrayList;
public class MergeSort {
    public static void main(String [] args) {

        // The principle is Divide and conquer.

        /**
         * APPROACH: 1. We divide the array into 2 sub arrays.
         *           2. We pick each array and further divide it. The process keeps on happening till we arrive at
         *              single element level . Since that element will always be sorted.
         *           3. We then move back up and join the consequent single element in the correct sorted order.
         *           4. We do the same for the other array.
         *           5. This is done by merging, we merge the 2 arrays. This is done by taking 2 pointers: left and right each starting
         *              from the starting position of respective arrays.
         * 
         *           Merge sort has 2 core parts: DIVIDE: Recursion
         *                                        MERGE
         * 
         * NOTE: Ofcourse, we don't intend to create array at each level so we play using indices.
         */

        int arr[] = {3, 1, 2, 4, 1, 5, 2, 6, 4};

        int low=0;
        int high = arr.length-1;
        mergeSort(arr, low, high);

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]); 
        }
        

    }

    public static void mergeSort(int[] arr, int low, int high) {
        // If we arrive at the single array, divide no further.
        if(low>=high) {
            return;
        }

        int mid = (low+high)/2;

        // Left array
        mergeSort(arr, low, mid);

        // Right array
        mergeSort(arr, mid+1, high);

        // merge both arrays
        merge(arr, low, mid, high);
     }

     public static void merge(int arr[], int low, int mid, int high) {
        final var temp = new ArrayList<Integer>();

        int left = low;                  // Pointer at first index of left array.
        int right = mid+1;               // Pointer at first index of right array.

        while(left<=mid && right<=high) {

            if(arr[left]<=arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }

        while(left<=mid) {
            temp.add(arr[left]);
            left++;
        }
        
        while(right<=high) {
            temp.add(arr[right]);
            right++;
        }

        for(int i=low;i<=high;i++) {
            arr[i]=temp.get(i-low);
        }
     }

}