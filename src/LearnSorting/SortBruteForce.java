// Given an array of N integers, write a prog to implement selection sort.
public class SortBruteForce {
    public static void main(String [] args) {
      int[] arr = {13, 46, 24, 52, 20, 9};

      /**
       * APPROACH: 1. Take one loop i=0;i<a.length-> This will act as a counter loop.
       *           2. Another loop which will serve as a lookup. j=i+1;j<arr.length.
       *           3. A condition if a[i]>a[j] then, swap the values. 
       *           4. Time complexity: O(N*N) since its a nested loop.
       *           5. Space complexity: O(1)
       */

      for(int i=0;i<arr.length;i++) {
        for(int j=i+1;j<arr.length;j++) {
          // Condition for swapping.
          if(arr[j]<arr[i]) {
            // swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j]= temp;
          }
        }
      }

      // Printing the array.
      for(int i=0;i<arr.length;i++) {
        System.out.println(arr[i]);
      }

    }
}