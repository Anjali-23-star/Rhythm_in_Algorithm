public class ReverseDigit {
    public static void main (String [] args) {
        
        // 12345 -> 54321
        // 10400 -> 401

        int N = 10400;
        int rev = 0;

        while(N>0) {
            int rem = N%10;
            rev = rev*10+rem;
            N/= 10;
        }

        System.out.println(rev);

    
    }
}
