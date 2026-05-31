/**
 * So, for too many number > pow(10,7), we can't make array and use array hashing. So, we are going to use
 * Hash map.
 */
import java.util.HashMap;
import java.util.Scanner;
public class usingHashMap {
    public static void main(String[] args) {
        int[] arr = {1 , 3, 4, 7, 4, 1, 3};

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            int key = arr[i];
            mpp.put(key, mpp.getOrDefault(key, 0)+1);
        }

        // For queries.
       System.out.println("Enter number to search.");
       
       Scanner input = new Scanner(System.in);
       int q = input.nextInt();

       do {
       

        System.out.println(q+ " appears "+ mpp.get(q)+" times.");
         q = input.nextInt();
       }while(q!=-1);

    }
    
}
