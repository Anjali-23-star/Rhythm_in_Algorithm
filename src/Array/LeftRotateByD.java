package Array;

// Left rotate the elements by D places.
// [1,2,3,4,5,6,7], d=2 => [3,4,5,6,7,1,2].
public class LeftRotateByD {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        //bruteForce(arr.clone(),arr.length, 3);
        optimal(arr, arr.length, 3);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }

    }

    public static void bruteForce(int[] a, int n, int d) {
        /**
         * APPROACH: 1. Store the elements.
         *           2. Shift the elements and place the store elements.
         *
         *           time comp: O(d)+O(n-d)+O(d)
         *           space comp: Since, I am using a temperoary variable to store elements,
         *                      the complexity is O(d).
         */
        d=d%n;

        int[] temp = new int[d];

        for(int i=0;i<d;i++) {
            temp[i]=a[i];
        }

        for(int i=d;i<n;i++){
            a[i-d] = a[i];
        }

        for(int i=n-d;i<n;i++) {
            a[i]=temp[i-(n-d)];
        }
    }

    public static void optimal(int [] arr, int n, int d) {
        /**
         * APPROACH:
         *          1. We reverse upto dth element.
         *          2. We reverse the the n-d th elements.
         *          3. We reverse the entire array.
         *
         *  TIME COMPLEXITY: O(d)+O(n-d)+O(n)
         *  SPACE COMPLEXITY: O(1).
         */

        d = d%n;

        // reverse upto dth element.
        reverse(arr, 0, d-1);
        // reverse the remaining elements.
        reverse(arr, d, n-1);
        // reverse whole array.
        reverse(arr, 0, n-1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while(start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
