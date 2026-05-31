public class InsertionSorting {
     public static void main(String [] args) {
        int [] arr = {14, 9, 15, 12, 6, 8, 13};

        /**
         * INSERTION SORT: Takes an element and puts it in its correct position.
         * 
         * APPROACH:
         *           1. We pick one element(key) and compare it with the elements before it.
         *           2. The elements are shifted right till they follow condition: elements>key.
         *           3. The key is then placed at its correct position.
         * 
         *           e.g [14,9]    i) key = 9 // starts from 1
         *                         ii) arr[0]> key?  shift to the right arr[1] = arr[0]
         *                        iii) Put key into its correct position arr[0] = key
         */

        for(int i=1;i<arr.length;i++) {
          
            int key = arr[i];      // Picking the current element
            int j = i-1;

            while(j>=0 && arr[j] > key) {
               arr[j+1] = arr[j];              // creating space by shifting elements to the right.
               j--;
            }

            arr[j+1] = key;
        }

       for(int i=0;i<arr.length;i++) {
        System.out.println(arr[i]);
       } 
    }
        
}