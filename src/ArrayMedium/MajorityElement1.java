package ArrayMedium;

import java.util.HashMap;

// Find majority element of the array. It is the element which appears more than n/2 times.
public class MajorityElement1 {
    public static void main(String[] args) {

        int[] arr = {7,0,0,1,7,7,2,7,7,9,7,9,7,7,7,7,7,7,7,9,9};

      System.out.println(brute(arr.clone()));
      System.out.println(better(arr));

        System.out.println(optimal(arr));
    }

    public static int brute(int[] arr) {
        /**
         * APPROACH:
         *          1. Iterate over each element and check it with others. Store the occurence in
         *             count.
         *          2. Since, we want the value of that element, store it in number var.
         *          3. TIME COMPLEXITY: O(n2) and SPACE COMPLEXITY: O(1).
         */
        int j=0, maxL=0, count=0, number=0;

        while(j<arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > arr.length / 2) {
                if (count > maxL) {
                    number = arr[j];
                }
                maxL = Math.max(count, maxL);
            }
                count = 0;

                j++;
            }


        return number;
    }

    public static int better(int[] arr) {
        /**
         * APPROACH:
         *          1. We create a map with value of array as key and its count as map value.
         *          2. We look up and pick the element from the map whose value>n/2.
         *
         *          TIME COMPLEXITY: O(n+n)~O(n). SPACE COMPLEXITY: O(n).
         */
        final var hashMap = new HashMap<Integer, Integer>();

        for(int i=0;i<arr.length;i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i],0)+1);
        }

        for(final var entrySet: hashMap.entrySet()) {
            // Checks if any value is >n/2, return the key.
            if(entrySet.getValue()>arr.length/2) {
                return entrySet.getKey();
            }
        }

        return -1;
    }

    // MOORE'S VOTING ALGORITHM.
    public static int optimal(int[] arr) {
        /**
         * APPROACH:
         *          Basically if the element is majority, it can't be cancelled.
         *          I told you. There were more of us
         *
         *          1. Taking first element as our answer and counting its occurrence.
         *          2. Each time I encounter my element, I do count++, each time I won't its count--
         *          3. If count becomes 0 i.e. its being canceled, i take another element.
         *          4. Perform the same thing.
         *          5. At last, if i have any element that has withstood the cancellation
         *             i.e count!=0, that element will be my answer only if it satisfies another
         *             condition: the element count>arr.length/2.
         *
         *          TIME COMPLEXITY: O(n)
         *          SPACE COMPLEXITY: O(1)
         */

        int element=-1;
        int count=0;

        for(int i=0;i<arr.length;i++) {
            if(count==0) {
                element=arr[i];
                count=1;
            }

            else if(arr[i]==element) {
                count++;
            }

            else {
                count--;
            }

        }

        int length=0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]==element) {
                length++;
            }

            if(length>arr.length/2) {
                return element;
            }
        }

        return -1;
    }
}
