package BinarySearchOnAnswers;

// Return the min integer K such that Koko can eat all bananas with 'h' hours.

/**
 * CONCEPT:
 *            piles = [3 6 7 11] h = 8 hours.
 *            If k = 2 bananas/hour. Total time = 3++3+4+6 =15>8 .
 *            We try the same with k=3, k=4 etc. and find for k=4, we have total hours = 8.
 *            And that will be our answer.
 *
 *            TIME COMPLEXITY: O(maxPile X n)
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int targetHour = 8;

        System.out.println(brute(piles, targetHour));
        System.out.println(optimal(piles, targetHour));
    }

    public static int brute(int[] arr, int target) {
        // k= number of hour koko takes to finish the pile.
        int k=1, answer = 0;

        while(true) {
            answer = 0;
            for (int i = 0; i < arr.length; i++) {
                answer += (int) Math.ceil((double)arr[i]/k);
            }

            if(answer <= target) {
                return k;
            }
            else{
                k++;
            }
        }
    }

    public static int optimal(int[] arr, int h) {
        /**
         * APPROACH:
         *           We observe that we actually know the bound of our answer.
         *
         *           The minimum possible speed/hour = 1 .
         *           The maximum possible speed/hour = Maximum element in our piles.
         *

         *           so, we ask:
         *           can koko finish at the speed of 'mid' per hour?
         *           If yes, then we keep on searching in the low branch because we want
         *           minimum hours under which koko can finish.
         *
         *           If no, then she is taking longer, we look in the higher side of branch.
         *
         *           TIME COMPLEXITY O(n log(maxPile))
         */
        int low = 1;
        int high = maxValue(arr);
        int answer = Integer.MAX_VALUE;

        while(low<=high) {
            int mid = low+(high-low)/2;
            int totalHours = 0;
            for(int i=0;i<arr.length;i++) {
                totalHours += (int) Math.ceil((double)arr[i]/mid);
            }

            // This could be our potential answer, but since we want minimum, we keep on looking
            // on the lower side of branch.
            if(totalHours<=h) {
                answer = Math.min(answer, mid);
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return answer;
    }
    public static int maxValue(int[] arr) {
        int max = arr[0];

        for(int i=1;i<arr.length;i++) {
            if(arr[i]>max) {
                max = arr[i];
            }
        }

        return max;
    }


}

