package ArrayMedium;

// Given an integer array nums, find the sub array with the largest sum and return the
// sum of the elements present in sub array.

public class MaximumSubArraySum {
    public static void main(String[] args) {

        //int[] arr = {-2, -3, -7, -2, -10, -4};
        int[] arr = {5, 3, 5, -2, 6, -4};

        System.out.println(brute(arr.clone()));
        System.out.println(optimal(arr.clone()));
    }

    public static int brute(int[] arr) {
        /**
         * APPROACH:
         *          1. Generate all possible subarrays.
         *          2. Take maxSum to be the lowest integer value(since we have negatives).
         *          3. Then return the max sum. Note, after the ending of 'j' loop for an 'i',
         *             the sum value is reinitialized to 0.
         *
         *          TIME COMPLEXITY: O(n2)
         *          SPACE COMPLEXITY: O(1)
         */
        int sum=0, maxSum=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++) {
          for(int j=i;j<arr.length;j++) {
              sum+=arr[j];

              maxSum = Math.max(sum, maxSum);
          }
          sum=0;
        }

        return maxSum;
    }

    // KADANE'S ALGORITHM: DROP THE SUM IF ITS NEGATIVE.
    public static int optimal(int[] arr) {
        /**
         * APPROACH:
         *          1. Taking 2 vars: sum and max=Integer.MIN
         *          2. For each iteration:
         *              1. We check if curr_value>max
         *                     max=curr_value.
         *              2. We store sum=curr_value
         *              3. If sum<0: don't carry it forward
         *                    so, sum=0.
         *
         *          TIME COMPLEXITY: O(N)
         *          SPACE COMPLEXITY: O(1)
         */


        int sum=0, max= Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++) {
            sum += arr[i];

            max = Math.max(sum, max);

            // drop the sum if its negative.
            if(sum<0) {
                sum=0;
            }
        }

        return max;
    }
}
