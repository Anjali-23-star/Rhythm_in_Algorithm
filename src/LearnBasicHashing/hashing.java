import java.util.Scanner;

public class hashing{
    public static void main(String [] args) {
    /**
     * APPROACH: Hashing is pre storing and fetching.
     *          I want to look up numbers to find their frequency in the array.
     *          1. Create a hash table where the index of the table = value of the original array.
     *          2. The value of hash table = count of the index value of the hash table-count from the original array, ofcourse.
     *          3. The length of the hash table is to be intialized by the maximum searchable value. - range.
     */

    int[] arr = {1,2,3,1,2};

    int[] hash = new int[11];

    // Taking input from the user.
    var input = new Scanner(System.in);
    var number = input.nextInt();

    for(int i=0;i<arr.length;i++) {
        hash[arr[i]] += 1;
    }

    // User asks for an input and we fetch the frequency of that value.
    if(number <hash.length) {
    System.out.println(number+ " appears "+ hash[number] + " times");
    }
    else {
        System.out.println("Number is out of range.");
    }
}
}