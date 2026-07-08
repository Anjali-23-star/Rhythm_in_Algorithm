package BinarySearchOnAnswers;

public class SquareRootOfANumber {
    public static void main(String[] args) {
        int n = 28;

        System.out.println(optimal(n));
    }

    public static int optimal(int n) {
        /**
         * APPROACH:
         *           1. For every square(mid)>n, search in the lower branch.
         *           2. For every square(mid)<=n, keep the mid and search in the higher branch to
         *              get the highest number <=n.
         */
        int low = 1;
        int high = n;
        int answer = 1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            if((long)mid*mid<=n) {
                answer = mid;

                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }

        return answer;
    }
}
