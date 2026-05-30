package ArrayMedium;

// Given an array consisting of only 0,1, and 2s sort in ascending order. in place, without copy.
public class SortArray0s1s2s {
    public static void main(String[] args) {
        int[] arr = {1,0,2,1,0};
        //better(arr);

        optimal(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void better(int[] arr) {
        /**
         * APPROACH:
         *          1. Important thing: We only have 0s,1s and 2s. We will make use of that.
         *          2. We iterate over the array and keep count of 0s,1s and 2s.
         *          3. Then, we place the numbers in the array back in accordance with their counts.
         *
         *          TIME COMPLEXITY: O(N+N)~ O(N).
         *          SPACE COMPLEXITY: O(3)
         */
        int zeroCount=0, onesCount=0, twosCount=0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]==0) {
                zeroCount++;
            }
            else if(arr[i]==1) {
                onesCount++;
            }
            else{
                twosCount++;
            }
        }


        // Filling with 0s.
        for(int i=0;i<zeroCount;i++) {
            arr[i]=0;
        }

        // Filling with 1s.
        for(int i=zeroCount;i<zeroCount+onesCount;i++) {
            arr[i]=1;
        }

        // Filling with 2s.
        for(int i=zeroCount+onesCount;i<arr.length;i++) {
            arr[i]=2;
        }
    }

    /**
     * DUTCH NATIONAL FLAG ALGO(3 POINTERS)
     */
    private static void optimal(int[] arr) {
        /**
         * APPROACH:
         *          INTUITION: Build Zones. 0th zone, 1 zone and 2 zone.
         *                    The idea is to shrink the array into these zones.
         *
         *                    |O ZONE | 1 ZONE | UNKNOWN ZONE | 2 ZONE |
         *
         *                    low       : Next position where 0 should go.
         *                    mid       : Current position of the element.
         *                    high      : Next position where 2 should go.
         *
         *                    If(arr[mid]==0)
         *                    -> swap arr[low],arr[mid]
         *                       low++, mid++  (Expand 0th Zone) and go to next element.
         *
         *                    If(arr[mid]==1)
         *                    -> We have our value at the right place. Just go to next element.
         *                       mid++
         *
         *                    If(arr[mid]==2)
         *                    -> swap(arr[mid],arr[high]) because 2 belongs to the last zone.
         *                       But now, we don't know what the swap value is.
         *                       The arr[mid] value remains to be checked.
         *                       We shrink the unknown array by high.
         *                       high--
         *
         *          TIME COMPLEXITY: O(N)
         *          SPACE COMPLEXITY: O(1)
         *
         */

        int low=0,mid=0,high=arr.length-1;

        while(mid<=high) {
           if(arr[mid]==0) {
               int temp = arr[mid];
               arr[mid]=arr[low];
               arr[low]=temp;

               mid++;
               low++;
           }

           else if(arr[mid]==2) {
               int temp = arr[mid];
               arr[mid]=arr[high];
               arr[high]=temp;

               high--;
           }

           else{
               mid++;
           }
        }

    }
}
