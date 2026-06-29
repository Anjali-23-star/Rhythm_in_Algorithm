package BinarySearch;
// floor = arr[i]<=x. ceil arr[i]>=x (the smallest number which is greater than equal to x)
public class FloorAndCeiling {
    public static void main(String[] args) {
        int[] arr = {3,4,4,7,8,10};
        int x = 5;

        System.out.println(ceiling(arr, x));
        System.out.println(floor(arr, x));
    }

    public static int floor(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        int answer = -1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            // in floor we want the highest element that would be less than equal to x so we shift toward the right.
            if(arr[mid]<=x) {
                answer = arr[mid];
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return answer;
    }

    // lower bound concept.
    public static int ceiling(int[] arr, int x) {
        int low =0;
        int high = arr.length-1;
        int answer = -1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            if(arr[mid]>=x) {
                answer = arr[mid];

                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return answer;
    }
}
