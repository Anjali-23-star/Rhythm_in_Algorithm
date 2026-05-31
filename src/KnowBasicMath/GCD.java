public class GCD {
    public static void main(String [] args) {
        int N1 = 9;
        int N2 = 12;
        int gcd = 1;
        /**
         * APPROACH:
         *           1. Count till the minimum of the 2 elements.
         *           2. Check for the common factor of both N1 and N2.
         *           3. But since, we only want the highest, we start with the min of the 2 numbers
         *              and break the moment we find the first common divisor.
         *           4. The benefit is that, if we have large numbers, the number of iterations can 
         *              be reduced.
         *              
         */
        for(int i =Math.min(N1, N2); i>1; i--) {
            if((N1%i==0) && (N2%i==0)) {
                gcd = i;
                break;
            }
        }


        /**
         * APPROACH 2: The Eucledian method.
         * COMPLEXITY: O(logn): for each iteration, the problem size shrinks which is what we mean by logarithm.
         * 
         * GCD(a,b) = b/a%b
         * GCD(12,9)
         */
        
        while(N2>0) {
           int temp =N2;
            N2= N2%N1;
            N1 = temp;
        }


        System.out.println("gcd is "+ gcd);
        System.out.println("gcd isss" + N1);
    }
}