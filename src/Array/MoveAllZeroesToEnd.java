package Array;

// Moving all zeroes to the end of the array.
public class MoveAllZeroesToEnd {
    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};

        int[] result = bruteForce(arr.clone());
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+" ");
        }

        optimal(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static int[] bruteForce(int[] arr) {
        /**
         * APPROACH:
         *           1. Pick all non-zero elements and store it in temperoary variable.
         *           2. Then, put these elments back in the original array.
         *           3. The remaining rest of the values are already intialized to 0.
         *
         *           TIME COMPLEXITY: O(2N)
         *           SPACE COMPLEXITY: O(N)
         */
        int[] temp = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp[j] = arr[i];
                j++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }

    public static void optimal(int[] arr) {
       int j=-1;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
       for(int i= j+1;i<arr.length;i++) {
           if(arr[i]!=0) {
               int temp = arr[j];
               arr[j]=arr[i];
               arr[i]=temp;

               j++;
           }
       }
    }
}