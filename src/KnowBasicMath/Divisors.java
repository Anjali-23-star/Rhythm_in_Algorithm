public class Divisors {
    public static void main(String[] args) {
        int N = 36;
        int i =1;

        /**
         * APPROACH:
         *          1. I can go till the number N but, the complexity becomes O(N).
         *          2. So, using math, I go till sqrt(N) because after that, the divisors
         *             are only mirror image.
         *          3. I go till sqrt(N) then to calculate other pair for each i, I do N/i simply.
         */
        while(i<=Math.sqrt(N)) {
            if(N%i==0) {
                System.out.print(" "+i);

                // This is to prevent duplicate. eg. 6*6 so, should be printed only 1 time.
                if(i != N/i) {
                    System.out.println(" "+N/i);
                }
            }
            i++;
        }
    }
    
}
