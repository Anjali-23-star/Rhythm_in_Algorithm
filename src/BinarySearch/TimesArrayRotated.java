package BinarySearch;

// Find how many times array is rotated: [3,4,5,1,2]: answer=3.
public class TimesArrayRotated {
    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 1, 2};
        optimal(arr);
    }

    public static void optimal(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int minimumIndex = Integer.MAX_VALUE;


            while (low <= high) {

                int mid = low+(high-low)/2;

                //If left half is sorted.
                if (arr[low] <= arr[mid]) {
                    // store the index of 'potential minimum' to the variable.
                    minimumIndex = Math.min(minimumIndex, arr[low]);

                    low = mid + 1;
                } else {
                    // The right is sorted, store the 'potential minimum' to the variable.
                    minimumIndex = Math.min(arr[mid], minimumIndex);

                    high = mid - 1;
                }
            }


        System.out.println(minimumIndex);
    }
}
