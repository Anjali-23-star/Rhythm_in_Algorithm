package BinarySearch;

public class LastOccurrenceInSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,4,13,13,13,20,40};
        int target = 13;

        System.out.println(optimal(arr, target));
    }

    public static int optimal(int[] arr, int target) {
        int low =0;
        int high = arr.length-1;
        int answer = -1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            if(arr[mid]==target) {
                answer = mid;
                // we want to find the last occurrence, and its a sorted array.
                // So, we will go towards the higher branch of partition.
                low = mid+1;
            }
            else if(arr[mid]>target) {
                // shrink the array to lower half.
                high = mid-1;
            }
            else {
                low=mid+1;
            }
        }

        return answer;
    }
}
