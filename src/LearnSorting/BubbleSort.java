// Implement bubble sort to sort an array.

/**
 * In bubble sort, the max element is pushed to the end of array using adjacent sorting.
 * The sorting builds from the end.
 */
public class BubbleSort {
    public static void main(String [] args) {

        int[] arr = {13,46,24,52,20,9};

        /**
         * APPROACH: 1. Take one counter loop-i.
         *           2. Take another loop j. and swap when arr[j]>arr[j+1];
         *           3. Since the sorting starts from the end, each time I pick an 'i', I have one less element to sort
         *              since the last element will be sorted for i=0, for i=1, last 2 elements will already be sorted
         *              and so on.
         * 
         *           4. For the average and worst case:
         *              TIME COMPLEXITY = O(n2)
         *              SPACE COMPLEXITY = O(1)
         * 
         *              BUT for the best case - When the array is already sorted, the complexity is O(N) i.e linear time.
         */
        for(int i=0;i<arr.length;i++) {
            boolean isSwap = false;
            for(int j=0;j<arr.length-(i+1);j++) {
                if(arr[j]>arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                    isSwap = true;  // elements are swapped.
                 }
            }

            if(!isSwap) {        
                break;           // Time complexity = O(N).
            }
        }

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
       
    }
}