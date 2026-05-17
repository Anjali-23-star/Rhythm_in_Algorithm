package Array;

//Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.
public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,0,1,1,0,0,1,1,1,1};
        int result = bruteForce(arr);
        System.out.println(result);
    }

    public static int bruteForce(int[] arr) {
        /**
         * APPROACH:
         *          1. 2 variables to store the current count and the best count of consecutive ones.
         *          2. On each encounter with zero, check if best count<current count
         *                 -> replace best count with the current count.
         *          3. Reinitialize the current count to 0.
         *
         *          TIME COMPLEXITY:O(N)
         *          SPACE COMPLEXITY: O(1)
         */
        int currentCount=0, bestCount=0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]==1) {
                currentCount+=1;
            }

            else {
                bestCount = Math.max(bestCount, currentCount);
                currentCount = 0;
            }
        }

        return Math.max(bestCount, currentCount);
    }
}
