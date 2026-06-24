package ArrayHard;

//Given an array[1,n] : A appears twice and B appears missing. return an arrray containis [A,B].
public class FindRepeatingAndMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {3,5,4,1,1};

        brute(arr);
        System.out.println("************");
        better(arr);
    }

    public static void brute(int[] arr) {
        /**
         * APPROACH:
         *          1. We first find out maximum element in array, since its a sequential array from 1 to n.
         *          2. Then for each n-1, we check how many times it occurs in an array.
         *          3. If its 0->then that is our missing element.
         *             If its >1 then it is our repeating element.
         *
         *             TIME COMPLEXITY: O(N2)
         *             SPACE COMPLEXITY: O(1)
         */

        int max =Integer.MIN_VALUE;
        int missingVal=0, repeatingVal=0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]>max) {
                max = arr[i];
            }
        }

        int currentElement=max;
        int count;

        while(currentElement>0) {
            count=0;
            for(int i=0;i<arr.length;i++) {
                if(currentElement==arr[i]) {
                    count++;
                }
            }

            if(count==0) {
                missingVal=currentElement;
            }

            if(count>1) {
                repeatingVal=currentElement;
            }

            currentElement--;
        }

        int[] result = new int[2];
        result[0]=missingVal;
        result[1]=repeatingVal;

        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+" ");
        }
    }

    /**
     * APPROACH: Create a frequency array.
     *
     * TIME COMPLEXITY: O(N)
     * SPACE COMPLEXITY: O(N)
     */
    public static void better(int[] arr) {
        int [] result = new int[2];

        int[] freqArr = new int[arr.length+1];

        for(int i=0;i<arr.length;i++) {
            freqArr[arr[i]]++;
        }

        for(int i=1;i<freqArr.length;i++) {
            if(freqArr[i]==0) {
                result[0]=i;
            }
            if(freqArr[i]>1) {
                result[1]=i;
            }
        }

        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+" ");
        }
    }
}
