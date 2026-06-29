package BinarySearch;

//[4,5,6,7,0,1,2] k=0 output: 4. otherwise -1.
public class SearchInRotatedSorted {
    public static void main(String[] args) {

        int[] arr = {4,5,6,7,0,1,2};
        int[] arr1 = {7,8,9,1,2,3,4};
        int target = 8;

        System.out.println(optimal(arr, target));
        System.out.println(optimal(arr1, target));
    }

    public static int optimal(int[] arr, int target) {
        /**
         * APPROACH:
         *           Binary search works on sorted array. But in this case, the array is rotated.
         *           So, the condition has to change.
         *
         *           First we pick arr[mid] and check if its equal to target,
         *           if no: our job is to eliminate one branch, now we have to figure out which one.
         *
         *           But before that, we check if left half is sorted:
         *                                         Check if target lies in left half.
         *           Else check if target exists in right half.
         *           we check if arr[low]<=target<=arr[mid] ->the target exists in this branch.
         *           make high = mid-1.
         *           else make low = mid+1.
         *
         */

        int low =0;
        int high = arr.length-1;
        int answer=-1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            if(arr[mid]==target) {
                return mid;
            }

            // Check if left half is sorted, that means we can eliminate right.
            if(arr[low]<=arr[mid]) {
                // check if target exists in this sorted array.
                if(arr[low]<=target && target<=arr[mid]) {
                    high = mid - 1;
                }
                // if not, search in the right half.
                else {
                    low = mid + 1;
                }
            }
            // else right half is sorted, eliminate the left half.
            else {
                if(arr[mid]<=target && target<=arr[high]) {
                    low = mid+1;
                }
                // search in the low half.
                else {
                    high = mid-1;
                }
            }
        }

        return answer;
    }
}
