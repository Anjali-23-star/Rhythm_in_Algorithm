package BinarySearch;

// Given an array of N integers. Every number in the array except one appears twice. Find the single
// number in the array.
// {1,1,2,3,3,4,4} => answer: 2
public class SearchSingleElement {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
    }

    public static int optimal(int[] arr) {
        /**
         * APPROACH:
         *          We observe that if there is no single element, then each paris starts at an even index.
         *          We call this 'normal' zone.
         *
         *          However, after introducing a single element, the pairs after that starts from odd index.
         *          We call it 'shifted' zone.
         *
         *          So, we check mid: If its even, its partner will be at mid+1. for normal zone.
         *          If its odd, its partner will be at mid-1 for normal zone.
         *
         *          If either condition fails that means, that mid element is our single element.
         */

        int low = 0;
        int high = arr.length-1;
        int answer = -1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            // If we are at the even index.
            if(mid%2==0) {
                // Check if its partner exists.
                if (arr[mid] == arr[mid + 1]) {
                    // We are in normal zone so our single lies in upper half.

                    low = mid + 1;
                }
            }
            // We are at odd index.
            else if(mid%2!=0) {
                // Check if partner exists.
                if(arr[mid]==arr[mid-1]) {
                    // We are in normal zone, single lies in upper half.

                    low= mid+1;
                }

            }
            // There are no pairs.
            else {
                answer = mid;
            }
        }

        return answer;
    }
}
