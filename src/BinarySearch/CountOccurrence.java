package BinarySearch;

// [2,2,3,3,3,3,4], target = 3-> result: 4.
public class CountOccurrence {
    public static void main(String[] args) {

        int[] arr = {2,2,3,3,3,3,4};
        int target = 10;

        optimal(arr, target);
    }

    public static void optimal(int[] arr, int target) {
        /**
         * APPROACH: Array is sorted and we want searching. We will use binary search.
         *
         * 1. We find the index of first occurence of our target: i.
         * 2. We find the index of last occurence of our target: i'
         *
         * The count will be : i'-i+1
         *
         * TIME COMPLEXITY: O(LOGN)
         * SPACE COMPLEXITY: O(1)
         */
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        // if the target is not found.
        if(first==-1 || last == -1) {
            System.out.println(0);
        }
        else {
            System.out.println(lastOccurrence(arr, target) - firstOccurrence(arr, target) + 1);
        }
     }

     public static int firstOccurrence(int[] arr, int target) {
        // first occurrence: search in the lower half of array since array is sorted.
         int low =0;
         int high = arr.length-1;
         int answer =-1;

         while(low<=high) {
             int mid = low+(high-low)/2;

             if(arr[mid]==target) {
                 answer = mid;
                 // search through the lower branch to find first occurrence.
                 high = mid-1;
             }
             else if (arr[mid]>target) {
                 high = mid-1;
             }
             else {
                 low=mid+1;
             }
         }

         return answer;
     }

     public static int lastOccurrence(int[] arr, int target) {
        int low =0;
        int high = arr.length-1;
        int answer =-1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            if(arr[mid]==target) {
                answer = mid;
                // to find last occurrence, find the target in the upper branch.
                low = mid+1;
            }
            else if (arr[mid]>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return answer;
     }
}
