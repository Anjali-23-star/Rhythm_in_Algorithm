package ArrayMedium;

// Return the sub array having the maximum sum.
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {5, 3, 5, -2, 6, -4};

        // brute(arr);
        optimal(arr);
    }

    public static void brute(int[] arr) {
        /**
         * APPROACH:
         *          1. Track all the sub arrays.
         *          2. Find the max sum across all sub arrays.
         *          3. Store the indices: start index and end index the moment
         *             max value is found.
         *
         *          TIME COMPLEXITY: O(n2)
         *          SPACE COMPLEXITY: O(1)
         */
        int sum, maxSum = Integer.MIN_VALUE, startIndex = 0, endIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {

                sum += arr[j];
                // if the current sum is greater than the previous sum, store the start
                // and the end indices to track the sub array.
                if (sum > maxSum) {
                    startIndex = i;
                    endIndex = j + 1;
                }
                maxSum = Math.max(sum, maxSum);
            }
        }

        // print the sub array.
        for (int i = startIndex; i < endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // KADANE'S ALGO: Drop the sum if it turns out to be negative.
    public static void optimal(int[] arr) {
        int sum = 0, maxSum = Integer.MIN_VALUE, startIndex = 0, endIndex = 0, tempIndex=0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Found better sub array
            if(sum>maxSum) {
                maxSum = sum;

                startIndex = tempIndex;
                endIndex = i;
            }
            maxSum = Math.max(sum, maxSum);


            // Checks if sum is negative, don't carry it forward.
            if (sum < 0) {
                sum = 0;
                // Start of the new sub array.
                tempIndex = i+1;
            }
        }

        for (int i = startIndex; i<= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}