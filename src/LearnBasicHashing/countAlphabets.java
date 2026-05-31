import java.util.Scanner;

public class countAlphabets {
    public static void main(String [] args) {
        String s1 = "abcdeabcdab";

        int[] frequencyArr = new int[26];
        var input = new Scanner(System.in);
        char character = input.next().toLowerCase().charAt(0);


        /**
         * APPROACH :
         *             A character can't be subtracted direclty. So, we use ASCII value.
         *            1. Assumption: a->0, b->1....z->25 (according to english count.)
         *            2. Since frequency array index = value of the original array,
         *                                             but a=95 as ASCII value, so we use a trick: index=ch-'a' where
         *                                             ch=current alphabet.
         *                                             a-a=0, b-a=1..and so on.
         * 
         *             ch-'a' = 0 if ch='a' because, ASCII values gets subtracted.
         * 
         */

        for(int i=0;i<s1.length();i++) {
            frequencyArr[s1.charAt(i)-'a'] +=1;
        }

        if(character-'a'<frequencyArr.length) {
            System.out.println(character+" is "+frequencyArr[character-'a']+" times.");
        }
        else{
            System.out.println(character+" appears 0 times.");
        }

    }
}