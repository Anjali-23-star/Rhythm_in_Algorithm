public class Fibonacci {
    public static void main(String [] args) {
        /**
         * APPROACH: 1. Initialize 0th and 1st element.
         *           2. loop from 1 to N.
         *           3. Swapping.
         * 
         *           Time com. O(N-2) = O(N)
         *           Space com. O(1)
         */

        int N = 5;
        int a = 0;
        int b = 1;
        System.out.print(a + " ");
        System.out.print(b + " ");
        int c;
        for(int i=2;i<=N;i++) {
            c=a+b;
             System.out.print(c+ " ");
            int temp = a;
            a = b;
            b = c;
        }
    }
}