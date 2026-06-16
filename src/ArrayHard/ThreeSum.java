package ArrayHard;
import java.util.*;

// Given an array of integers, finding unique triplets that add up to 0.
// [-1, 0, 1, 2, -1, -4]=>  output: [[-1, -1,2],[-1,0,1]]
public class ThreeSum {
    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr1 = {-2, -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2, 2};

        brute(arr.clone());
        System.out.println("*****************");
        better(arr.clone());
        System.out.println("******************");
        optimal(arr1);
    }

    public static void brute(int[] arr) {
        /**
         * APPROACH:
         *           1. Generate all the possible triplets. So, we require 3 loops.
         *           2. The condition is : The triplets must be unique. This means
         *               -> Sort the triplet first.
         *               -> Store it in a set.
         *
         *           TIME COMPLEXITY: O(N3)
         *           SPACE COMPLEXITY: 2*O(number of triplets).
         */
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {

                    // Creating a list to store the triplet.
                    List<Integer> list = new ArrayList<>();

                    if (arr[i]+arr[j]+arr[k] == 0) {
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);

                        // Sort the list.
                        Collections.sort(list);

                        // To prevent duplicate, we store the list in a set.
                        set.add(list);

                    }
                }
            }
        }

       System.out.println(set);
    }

    public static void better(int[] arr) {
        /**
         * APPROACH:
         *            Fix the 2 sums and check if target=-(arr[i]+arr[j]) exists in our set?
         *            If yes-> we found our triplet. If no-> Go on.
         *
         *            IMPORTANT NOTE: Don't blindly store all elements in set for looking up target.
         *                            We only store numbers visited for this 'i'.
         *                            So, we don't count the element twice.
         *
         *            TIME COMPLEXITY: O(N2)+O(NLOGN)
         *            SPACE COMPLEXITY: O(N)
         */

        final var result = new HashSet<List<Integer>>();

        for(int i=0;i<arr.length;i++) {

            // Initialize the set with remaining 'j' elements.
            final var set = new HashSet<Integer>();
            for(int j=i+1;j<arr.length;j++) {

                int target = -(arr[i]+arr[j]);

                if(set.contains(target)) {
                    final var list1 = new ArrayList<Integer>();

                    list1.add(arr[i]);
                    list1.add(arr[j]);
                    list1.add(target);

                    // Sorting the list and preventing the duplicates to make it to the result.
                    Collections.sort(list1);

                    result.add(list1);
                }

                set.add(arr[j]);
            }
        }

        System.out.println(result);
    }

    public static void optimal(int[] arr) {

        /**
         * APPROACH:
         *           1. First, to handle the duplicate issue, we Sort our array. This is very important
         *              for our 2 pointer technique
         *           2. We take start= starting of our triplet.
         *                      mid = middle of our triplet.
         *                      end = end of our triplet.
         *
         *                      Ofcourse, mid<end.
         *           3. We place pointers to their respective positons and check if
         *              arr[i]+arr[j]+arr[k]=0.
         *              If yes -> We got our triplet.
         *
         *              If no-> we check if arr[i]+arr[j]+arr[k]<0 i.e we have to increase it.
         *                 So, we move the value of 'j' forward.
         *
         *                 If arr[i]+arr[j]+arr[k]>0, we have to decrease it, we have to move our
         *                 pointer 'k' backward.
         *
         *                 NOTE: It only makes sense since our array is "SORTED".
         *
         *               Important point is: When we move pointer just make sure that the value of the
         *                next is unique.
         *
         *            TIME COMPLEXITY: NlogN+O(N2)
         *            SPACE COMPLEXITY: O(NUMBER OF UNIQUE TRIPLETS)
         */
        List<List<Integer>> result = new ArrayList<>();
        // sorting the array.
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                // check if it is our triplet.
                int sum = arr[i] + arr[j] + arr[k];

                // Increase it.
                if (sum < 0) {
                    j++;
                }
                // Decrease it.
                else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);

                    result.add(list);

                    j++;
                    k--;

                    // But check that the current j's and k's value are not equal to previous.
                    while (j<k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j<k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }

            }
        }

        System.out.println(result);
    }
}