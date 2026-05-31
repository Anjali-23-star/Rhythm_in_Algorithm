public class SelectionSort{
    public static void main(String [] args) {

        int[] arr = {13, 46, 24, 52, 20, 9};
        int minIndex=0;
        /**
         * APPROACH:
         *          1. We use 2 loops. One counter loop(i) and the other lookup loop(j).
         *          2. We take the smallest value to be at the index i.
         *          3. We find the smallest value across the rest of the array and put minindex=j.
         *          4. We swap the elements.
         */

        for(int i=0;i<arr.length;i++){
            minIndex = i;
            for(int j=i+1;j<arr.length;j++) {
              // Finding the smallest value.
              if(arr[j]<arr[minIndex]) {
                minIndex = j;
              }
            }

            // Swapping the ith element with the smallest value.
            int temp = arr[i];
            arr[i]= arr[minIndex];
            arr[minIndex] = temp;
        }

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}