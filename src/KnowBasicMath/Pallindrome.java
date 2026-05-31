public class Pallindrome {
    public static void main(String [] args) {
        int number = 123;
        int reverseNumber = 0;

        int temp = number;

        while(temp >0) {
            int rem = temp%10;
            // Adding to reverse number.
            reverseNumber = reverseNumber*10 + rem;

            // Removing last digit from number.
            temp = temp/10;
        }

        // Checking for pallindrome.
        if(number == reverseNumber) {
            System.out.print(number+"is a pallindrome.");
        }
    }
}
