package ArrayHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Given an array of intervals where intervals[] = [start,end], merge all overlapping intervals and
// return an array of the non overlapping intervals that cover all the intervals in the input.
public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>(List.of(List.of(1,3),
                List.of(2,6),
                List.of(8,9),
                List.of(9,11),
                List.of(8,10),
                List.of(2,4),
                List.of(15,18),
                List.of(16,17)));
        brute(list);
        System.out.println("**********");
        optimal(list);
    }

    public static void brute(List<List<Integer>> list) {
        /**
         * LEARN FROM MISTAKE: List.of() is immutable.
         *                     Be wary of the index use: if its of original list, you can't access new list
         *                     from that index, because size will be different.
         * APPROACH:
         *          1. First, we sort our list of arrays.
         *          2. The intuition is we will pick the array's elements and then we
         *             compare to the rest of the elements if they overlap.
         *             What defines overlap?
         *             If the start of our traversing element is < end of our current merged end.
         *             then we update the end value of our previous element with max(nextend, end).
         *
         *             But, we also, have to skip all the elements which are already included in the
         *             overlap.
         *             For that, we will access the last added element to our result and check if the
         *             end of that element <= the end of our chosen element.
         *             If yes-> continue skip this. else, go on.
         *
         *             TIME COMPLEXITY: NLOGN+O(N2)
         *             SPACE COMPLEXITY: O(N') i.e the total overlapped elements, in worst case: O(N)
         */
        list.sort((list1, list2)-> {
            int comp = Integer.compare(list1.get(0), list2.get(0));
            if(comp!=0) {
                return comp;
            }
            return Integer.compare(list1.get(1), list2.get(1));
        });
        System.out.println(list);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<list.size();i++) {
            int start = list.get(i).get(0);
            int end = list.get(i).get(1);

            // Check if the current set is already included in the overlap set, ignore it.
            if(!result.isEmpty() && end <= result.get(result.size()-1).get(1)){
                continue;
            }
            for(int j=i+1;j<list.size();j++) {
                int nextStart = list.get(j).get(0);
                int nextEnd = list.get(j).get(1);

                if(nextStart<=end) {
                    // update the end.
                    end = Math.max(end, nextEnd);
                }
            }

            result.add(List.of(start,end));
        }

        System.out.println(result);
    }

    /**
     * APPROACH: We intend to do it in a single iteration.
     *
     * TIME COMPLEXITY: NLOGN+O(N)
     * SPACE COMPLEXITY: O(N')
     */
    public static void optimal(List<List<Integer>> list) {
        list.sort((list1, list2)-> {
            int comp = Integer.compare(list1.get(0), list2.get(0));
            if(comp!=0) {
                return comp;
            }
            return Integer.compare(list1.get(1), list2.get(1));
        });
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<list.size();i++) {
            int start = list.get(i).get(0);
            int end = list.get(i).get(1);

            if(result.isEmpty()) {
                result.add(Arrays.asList(start, end));
            }

            if(!result.isEmpty()) {
                if(result.get(result.size()-1).get(1)>start) {
                    //update the overlapped end.
                    int newMergedEnd = Math.max(end, result.get(result.size()-1).get(1));

                    result.get(result.size()-1).set(1, newMergedEnd);
                }
                else{
                    result.add(Arrays.asList(start,end));
                }
            }
        }

        System.out.println(result);
    }
}
