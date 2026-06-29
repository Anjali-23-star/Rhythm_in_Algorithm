package BinarySearch;

// Given sorted array of integer find index i such that arr[i]>=x, otherwise return size of array.
// [3,5,8,15,19], x=9 -> result: 3.
public class LowerBound {
    public static void main(String[] args) {

        int[] arr = {3,5,8,15,19};
        int x= 9;

        System.out.println(optimal(arr, x));
    }

    public static int optimal(int[] arr, int x) {
        /**
         * APPROACH:
         *           The key idea is to know that sorted and search means Binary search.
         *           Now, we break the array and check if arr[mid]>=x for our lower bound.
         *           If yes: well, then we again break down the array form low to mid-1. because
         *           mid is one of our possible answer , we have to keep on searching till we
         *           get the lower bound.
         *
         *           And if not, then we will search in the high branch of array.
         *
         *           TIME COMPLEXITY: O(logN)
         *           SPACE COMPLEXITY: O(1)
         */
        int low = 0;
        int high = arr.length-1;
        int answer= arr.length;

        // base condition
//        if (low > high) {
//            answer = arr.length;
//        }
        while (low <= high) {

            int mid = low+(high-low) / 2;

            if (arr[mid] >= x) {
                // a possible lower bound.
                answer = mid;


                // shrink the array towards left.
                high = mid - 1;
            } else {
                // since the array is in sorted order, our element resides in the right half.
                low = mid + 1;
            }
        }

        return answer;
    }
}
