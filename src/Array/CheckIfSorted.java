package Array;

// Check if an array is sorted.
public class CheckIfSorted {
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 3, 4};
        int [] arr1 = {1, 2, 1, 3, 4};

        System.out.println(isSorted(arr));
        System.out.println(isSorted(arr1));
    }

    public static boolean isSorted(int[] arr) {

        for(int i=1;i<arr.length;i++) {
            if(arr[i]<arr[i-1]) {
                return false;
            }
        }
        return true;
    }
}
