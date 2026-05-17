package Array;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// Remove duplicates from the sorted array(in place).
public class RemoveDuplicates {
    public static void main(String [] args) {

        int [] arr = {1,1,2,2,2,3,3};

        System.out.println(bruteForce(arr.clone()));

        System.out.println(optimal(arr.clone()));
    }

    public static int bruteForce(int [] a) {
        /**
         * APPROACH:
         *          1. Since, we need unique element, we use Set data structure.
         *          2. Once we insert elements in set, we pick those elements and
         *             insert it back to our array.
         *          3. The stopping index will give us # of unique element since, the
         *             index starts at 0.
         *          4. Important point to note: this is not in-place insertion. Also, don't use
         *             hash set since it won't garantee order since set is an unordered collection.
         *
         *             TIME COMPLEXITY: O(N)
         *             SPACE COMPLEXITY: O(N).
         */

        Set set = new LinkedHashSet();

        for(int i=0;i<a.length;i++) {
            set.add(a[i]);
        }

        int index = 0;
        // Inserting it back to the array.
        for(var x: set) {
            a[index] = (int) x;
            index++;
        }

        // The number of unique elements.
        return index;

    }

    public static int optimal(int [] a) {
        /**
         * APPROACH:
         *          1. Use two pointers: i and j.
         *          2. 'i' tracks the position of unique elements.
         *          3. 'j' scans the array to find next unique elements.
         *          4. When a new unique element is found, place it at 'i+1' and move 'i' forward.
         */
        int i=0;
        for(int j=1;j<a.length;j++) {
            if(a[j] != a[i]) {
                a[i+1] = a[j];

                i++;
            }
        }

        return i+1;
    }
}
