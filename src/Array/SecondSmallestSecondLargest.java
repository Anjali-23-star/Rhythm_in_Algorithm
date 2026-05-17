package Array;

// BRUTE FORCE.
// Find the second smallest and second largest, print -1 for in the event that neither of them exist.
public class SecondSmallestSecondLargest {
    public static void main(String [] args) {

        int[] arr = {1, 2, 4, 7, 7, 5};

        bruteForceSecondLargest(arr.clone());
        betterSecondLargest(arr.clone());
        optimalSecondLargest(arr.clone());

    }


    public static void bruteForceSecondLargest(int[] arr) {
        /**
         * APPROACH:
         *            1. First, sort the array in ascending order. (NlogN)
         *            2. Store largest = arr[n-1]: last element.
         *            3. Then compare arr[n-2] to largest
         *                     : if not equals: secondLargest = arr[n-2].
         *                     Worst case: traverse the entire array. O(N).
         *
         *            Total complexity: O(NlogN+N).
         */

        // Using insertion sort for sorting.
        for(int i=1;i<arr.length;i++) {
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        // largest element.
        int largest = arr[arr.length-1];
        int secondLargest = 0;

        for(int i=arr.length-2;i>=0;i--) {
            if(arr[i] != largest) {
               secondLargest = arr[i];
               break;
            }
        }

        System.out.println("Brute secondLargest = "+secondLargest);
    }

    public static void betterSecondLargest(int[] arr) {
        /**
         * APPROACH:
         *          1. First, find out the maximum element of an array.
         *          2. Assuming non-negative array, take secondLargest = -1.
         *          3. Loop: arr[i]>secondLargest && arr[i]<largest will be our number.
         *
         *          Complexity: O(2N).
         */

        int largest = arr[0];
        int secondLargest = -1;

        // Largest element.
        for(int i=1;i<arr.length;i++) {
            if(arr[i]>largest) {
                largest = arr[i];
            }
        }

        // Second largest element.
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>secondLargest && arr[i]<largest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("better: secondLargest = "+secondLargest);
    }

    public static void optimalSecondLargest(int[] arr) {
        /**
         * APPROACH:
         *          We do it side by side.
         *          1. First elemnt is the largest.
         *          2. Then on next iteration: compare it to first:
         *                                     if arr[i]>largest
         *                                     => smallest = largest
         *                                        largest=arr[i].
         *           3. Keep in mind the equality: don't swap if arr[i]==largest.
         *           4. Also, compare with the smallest value too.
         */
        int largest = arr[0];
        int secondLargest = -1;

        for(int i=1;i<arr.length;i++) {
            if(arr[i]>largest) {
                secondLargest = largest;
                largest = arr[i];
            }

            else if(arr[i]>secondLargest && arr[i]!=largest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("largest "+largest);
        System.out.println("second Largest"+secondLargest);
    }
}
