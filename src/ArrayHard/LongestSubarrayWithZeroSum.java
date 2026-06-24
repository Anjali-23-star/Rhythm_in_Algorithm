package ArrayHard;
import java.util.HashMap;

// Given an array containing both positive and negative numbers, find the length of the longest
// sub array with sum of all elements equal to zero.
public class LongestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {9,-3,3,-1,6,-5};
        int [] arr1 = {6, -2, 2, -8, 1, 7, 4, -10};

        System.out.println(brute(arr.clone()));
        System.out.println("************");
        System.out.println(brute(arr1.clone()));
        System.out.println("************");
        System.out.println(optimal(arr.clone()));
        System.out.println(optimal(arr1.clone()));
    }

    public static int brute(int[] arr) {
        int maxLength = Integer.MIN_VALUE;
        int elementCount;

        for(int i=0;i<arr.length;i++) {
            int sum = arr[i];
            elementCount=1;
            for(int j=i+1;j<arr.length;j++) {
                sum+=arr[j];
                elementCount++;

                if(sum==0) {
                   maxLength = Math.max(maxLength, elementCount);
                }
            }
        }

        return maxLength;
    }

    public static int optimal(int[] arr) {
        /**
         * APPROACH:
         *           IMPORTANT THINGS:
         *           1. To account for 0 index, first store the sum=0 at an index=-1.
         *           2. For sum=0, P(current)=P(previous-1) ie. we have to find if our current sum is seen before.
         *              If yes-> then update the max length.
         *           3. If no, then add that sum. It is imporant that we don't want repeated sum to be stored in hashmap.
         *              Only the first sum because we want longest subarray.
         */
       final var hashmap = new HashMap<Integer, Integer>();
       int sum=0, maxLength = Integer.MIN_VALUE;

       hashmap.put(0,-1);
       for(int i=0;i<arr.length;i++) {
           sum+=arr[i];

           // iterate over map to find out if it contains this sum.
           if(hashmap.containsKey(sum)) {
               //track the previous index where it is already seen.
               int previousIndex = hashmap.get(sum);
               // Remember the length of sub array in prefix sum is : whole length till i-whole length till previous index.
               maxLength = Math.max(maxLength, i-previousIndex);
           }else{
               hashmap.put(sum, i);
           }
       }

       return maxLength;
    }
}
