package ArrayMedium;

import java.util.*;

// Given a target. Return yes if exists numbers such that 2 sum=target.
// Return the indices of the 2 numbers, otherwise {-1,-1}.
public class TwoSum {
    public static void main(String[] args) {

        int[] arr = {2,6,5,8,11};
        int target = 14;

        bruteForce(arr.clone(), target);
        better(arr.clone(), target);
        System.out.println(optimal(arr.clone(), target));
    }

    public static void bruteForce(int[] arr, int k) {
        /**
         * APPROACH:
         *          1. Iterate through the loop and check if arr[i]+arr[j]==target.
         *             TIME COMPLEXITY: O(n*n) SPACE COMPLEXITY:O(1)
         */
        int [] result = {-1,-1};

        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if (arr[i] + arr[j] == k) {
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }

        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }

    public static void better(int[] arr, int k) {
        /**
         * APPROACH:
         *           1. Store in map:
         *              - Pick element.
         *              - Check if target-element stored in map? if not? put that 'element' in map.
         *              - Then pick other and go on. if 'yes' i.e. target-element already exists in map
         *              - We found our answer!
         *                Map<key, value> = (value, index).
         *           2. Iterate over each element and check if (target-element) exists in map.
         *           3. Our pair will be element,target-element.
         *           TIME COMPLEXITY: O(N), SPACE COMPELXITY:O(N)
         */

        final var hashMap = new HashMap<Integer, Integer>();
        int[] result = {-1,-1};

        for(int i=0;i<arr.length;i++) {
            int more = k-arr[i];

            if(hashMap.containsKey(more)) {
                result[0]=i;
                result[1]=hashMap.get(more);
            }

            else{
                hashMap.put(arr[i], i);
            }
        }

        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+" ");
        }
    }

    public static boolean optimal(int[] arr, int k) {
        /**
         * APPROACH:
         *          1.SORT the array first.
         *          2 POINTERS: LEFT AND RIGHT.
         *             - check if left+right==target? yes otherwise
         *             - is left+right> target: we got to reduce: right--
         *             - is left+right<target: we got to increase left++
         *          IMPORTANT NOTE: THIS IS OPTIMAL ONLY FOR THE CASE IF WE WANT YES/NO NOT THE INDEX.
         *          TIME COMPLEXITY: O(NlogN)(due to sorting) +O(N)= O(NlogN). space: O(1)
         */
        int left =0, right = arr.length-1;

        Arrays.sort(arr);

        while(left<right) {
            int sum = arr[left]+arr[right];

            if(sum == k) {
                return true;
            }
            else if(sum<k) {
                // increase.
                left++;
            }
            else if(sum>k) {
                // decrease
                right--;
            }
        }
        return false;
    }

}
