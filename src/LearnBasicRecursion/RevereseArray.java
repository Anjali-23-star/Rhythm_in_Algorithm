// Reverse an array.
public class RevereseArray {
    public static void main(String [] args) {
        int N[] = {1, 2, 3, 4, 5};
        int result [] = new int[5];
        int j = 0;
        /**
         * APPROACH:
         *            1. Iterate from the back of first array.
                      2. Put elements in other array.
         */
        for(int i = N.length-1 ; i>=0; i--) {
            result[j] = N[i];
            j++;
        }

        // Printing the result.
        // for(int i = 0; i< result.length;i++) {
        //     System.out.print(result[i]+" ");
        // }

        /**APPROACH 2: 1. Take 2 pointers(p1 and p2) pointing to the forward and the back of the array.
         *             2. For each iteration, swap the elements.
         *             3. Increment and decrement them respectively.
         *             4. The constraint is till p1<p2 since after p1=p2, the swapping of element will result
         *                array back to its original form.
         *             5. Time comp = O(N), Space comp = O(1).
         * **/

        int p1 = 0;
        int p2 = N.length - 1;

        while(p1<p2) {
            int temp = N[p1];
            N[p1] = N[p2];
            N[p2] = temp;

            p1++;
            p2--;
        }

        for(int i =0;i<N.length;i++) {
            System.out.println(N[i]);
        }
    }
}