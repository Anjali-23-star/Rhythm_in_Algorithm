package BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7};
        int x= 6;

        System.out.println(optimal(arr, x));
    }

    public static int optimal(int[] arr,int x) {
        /**
         * APPROACH:
         *          Basically, i just have to find out arr[i]>=target which is a lower bound problem.
         */
        int low = 0;
        int high = arr.length-1;
        int answer= arr.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

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
