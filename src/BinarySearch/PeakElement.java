package BinarySearch;

// Peak element arr[i-1]<arr[i]>arr[i+1]
// The bounds are -inf and -inf.
public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,5,1};
        int[] arr1 = {1,5,1,2,1};

        System.out.println(brute(arr));
        System.out.println(optimal(arr));
        System.out.println(optimal(arr1));

    }

    public static int brute(int[] arr) {
        /**
         * TIME COMPLEXITY: O(N)
         */
        for(int i=0;i<arr.length;i++) {
            if((i==0 || arr[i]>arr[i-1]) && (i==arr.length-1 || arr[i]>arr[i+1])) {
                return i;
            }
        }
        return -1;
    }

    public static int optimal(int[] arr) {
        int n = arr.length;

        /**
         * APPROACH:
         *         The idea is that we are at some mid element arr[mid]. we check if this element< the right one
         *         & this element> left one
         *         If yes, we are at an upward slope so we discard the left branch, because peak is upwards.
         *
         *         If no, ie. arr[mid]>right one and arr[mid]<left one, we are at valley the peak is towards the left
         *         side, cut off the high branch.
         *
         *         For our peak we always check if arr[mid-1]<arr[mid]>arr[mid+1].
         *
         *         However, see that we are chekcing mid-1 and mid+1. this will crash if we are at the fist
         *         element/last element. So, we put on three manual checks too.
         *
         *         if there is only one element:
         *         [1] that is our peak .
         *         if we are at 0 index and
         *         arr[0]>arr[1] that 0 is our peak index.
         *         if we are at last index and
         *         arr[n-1]>arr[n-2] then n-1 is our peak index.
         *
         *         NOTE: We always start with low=1 and high = n-2 because we have already
         *         processed the corner cases.
         */

        int low =1;
        int high = n-2;

        if(n==1) {
            return 0;
        }

        if(arr[0]>arr[1]) {
            return 0;
        }

        if(arr[n-1]>arr[n-2]) {
            return n-1;
        }

        while(low<=high) {
            int mid = low+(high-low)/2;

            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) {
                return mid;
            }

            // upward slope
            else if(arr[mid]>arr[mid-1]) {
                low = mid+1;
            }

            else if(arr[mid]>arr[mid+1]) {
                high = mid-1;
            }

            else {
                low=mid+1;
            }
        }
        return -1;
    }
}

