public class PallindromeByRecursion {
    public static void main(String [] s) {

        String s1="ABCBA";
        if(isPallindrome(s1, 0, s1.length()-1)) {
            System.out.println(s1+ " is a pallindrome.");
        }
    
    }
    public static boolean isPallindrome(String s1, int left, int right) {
        // Base case
        if(left>=right) {
            return true;
        }

        if(s1.charAt(left) != s1.charAt(right)) {
            return false;
        }

       return isPallindrome(s1, left+1, right-1);
    }

}