package BinarySearchOnAnswers;

// Return the min integer K such that Koko can eat all bananas with 'h' hours.

/**
 * CONCEPT:
 *            piles = [3 6 7 11] h = 8 hours.
 *            If k = 2 bananas/hour. Total time = 3++3+4+6 =15>8 .
 *            We try the same with k=3, k=4 etc. and find for k=4, we have total hours = 8.
 *            And that will be our answer.
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int targetHour = 8;

        System.out.println(brute(piles, targetHour));
    }

    public static int brute(int[] arr, int target) {
        // k= number of hour koko takes to finish the pile.
        int k=1, answer = 0;

        while(answer<=target) {
            answer = 0;
            for (int i = 0; i < arr.length; i++) {
                answer += (int) Math.ceil((double) arr[i] /k);
                System.out.println(answer);
            }

            if(answer == target) {
                return answer;
            }
            else{
                k++;
            }
        }
        return -1;
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

