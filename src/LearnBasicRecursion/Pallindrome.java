// Check if a string is pallindrome.
public class Pallindrome {
    public static void main(String [] args) {
        String s1 = "ABCBAE";
        int p1 = 0;
        int p2 = s1.length()-1;

        /**
         * APPROACH: 1. Storing it into the character array.
         *           2. Using 2 pointer approach to compare the elements.
         *           3. Using a flag to mark pallindrome. 
         */

        // char[] ch = new char[s1.length()];   // This will result in O(N) complexity.
        boolean isPallindrome = true;

        // Fill the char array.
        // Not required.
        // for(int i =0; i<s1.length();i++) {
        //     ch[i] = s1.charAt(i);
        // }

        while(p1<p2) {
            if(s1.charAt(p1) != s1.charAt(p2)) {
                isPallindrome = false;
                break;
            }

            p1++;
            p2--;
        }

        // Displaying result.
        if(isPallindrome) {
            System.out.println(s1 + " is a pallindrome.");
        }
        else {
            System.out.println(s1+" is not a pallindrome.");
        }
    }
}