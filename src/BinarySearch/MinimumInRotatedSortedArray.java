package BinarySearch;

// [4,5,6,7,0,1,2,3] -> 0 is the minimum element.
public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {

        int[] arr = {4,5,6,7,0,1,2,3};
        int[] arr1 = {3,4,5,1,2};
        int[] arr2 = {8,9,10,1,2,3,4,5,6,7};
        System.out.println(optimal(arr));
        System.out.println(optimal(arr1));
        System.out.println(optimal(arr2));
    }

    public static int optimal(int[] arr) {
        /**
         * Since its a rotated problem:
         * 1. we check if left is sorted.
         * 2. The smallest element will be arr[low]: for that left sorted array. but its not global min.
         * 3. Then we check in the right branch if low = mid+1.
         * 4. else the right one is sorted, we pick the first element. and then go to the left one.
         */
        int low =0;
        int high = arr.length-1;
        int minimum = Integer.MAX_VALUE;

        while(low<=high) {
            if(arr[low]<=arr[high]) {
                minimum = Math.min(minimum, arr[low]);
                break;
            }
            int mid = low+(high-low)/2;

            // check if the left half is sorted, then pick the arr[low] as the potential minimum.
            if(arr[low]<=arr[mid]) {
                minimum = Math.min(minimum, arr[low]);
                low = mid+1;

            }
            else{
                // The right half is sorted but we don't know where the element is.
                minimum = Math.min(minimum, arr[mid]);

                // search for the potential minimum in the left half.
                high = mid-1;
            }
        }

        return minimum;
    }
}
