package ArrayMedium;

public class AlternatePositiveNegative {
    public static void main(String[] args) {

        int[] arr = {1, 2, -3, -1, -2, 3};
        brute(arr.clone());
        optimal(arr.clone());
    }

    public static void brute(int[] arr) {
        /**
         * APPROACH:
         *           Utilizing the fact that there are equal pos and neg numbers.
         *           1. 2 arrays with only pos and neg numbers.
         *           2. Put the pos into even places.
         *           3. Put the neg into odd places.
         *
         *           TIME COMPLEXITY: ~O(n)
         *           SPACE COMPLEXITY: O(n)
         */
        int pos[] = new int[arr.length/2];
        int neg[] = new int[arr.length/2];
        int k=0,l=0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]>0) {
                pos[k++]=arr[i];
            }
            else{
                neg[l++]=arr[i];
            }
        }

        // Storing the values in the array.
        for(int i=0;i<arr.length/2;i++) {
            arr[2*i]= pos[i];
            arr[2*i+1]=neg[i];
        }

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]+ " ");
        }

    }

    public static void optimal(int[] arr) {
        /**
         * TIME COMPLEXITY: O(N)
         * SPACE COMPLEXITY: O(N)
         */
        int even=0, odd=1;
        int[] result = new int[arr.length];

        for(int i=0;i<arr.length;i++) {
            // if positive, shift to the even index.
            if(arr[i]>0) {
                result[even]=arr[i];
                // next even index. 
                even += 2;
            }
            // if negative, shift to the odd index.
            else{
                result[odd]=arr[i];
                // next odd index.
                odd += 2;
            }
        }

        for(int i=0;i<arr.length;i++) {
            System.out.print(result[i]+" ");
        }

        // printing result
    }
}
