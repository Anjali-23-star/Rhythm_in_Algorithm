package Array;

// Given an array containing both postive and negative integers, find the length of the longest
// sub array with sum of elements equal to 0.
public class LongestSubArrayWithZeroSum {
    public static void main(String[] args) {

        int[] arr = {9, -3, 3, -1, 6, -5};
        System.out.println(bruteForce(arr.clone()));

    }

    public static int bruteForce(int[] arr) {
       int sum=0, maxLength=0, i=0;

        while(i<arr.length) {
            sum=0;
            for(int j=i;j<arr.length;j++) {
                sum += arr[j];

                if (sum == 0) {
                    maxLength = Math.max(maxLength, j-i + 1);

                }
            }
            i++;
        }

        return maxLength;


    }
}
