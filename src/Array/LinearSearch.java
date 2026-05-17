package Array;

// Search the target and return the index of element in an array.
public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        System.out.println(search(nums, 9));
    }

    public static int search(int[] arr, int target) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==target) {
                return i;
            }
        }

        return -1;

    }
}
