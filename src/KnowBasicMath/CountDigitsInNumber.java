class CountDigitsInNumber {
    public static void main(String...s) {
        // N = 12345
        // Output = 5

        /**
         * APPROACH: while quotient != 0, count+=1
         */

        int N = 12345;

        int quot = N;
        int count = 0;

        while(quot!=0) {
            quot = quot/10;
            count += 1;
        }

        System.out.println(count);
    }
}