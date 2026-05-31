public class HighestLowestFrequencyBruteForce {
    public static void main(String [] args) {
        int[] arr = {10, 5, 10, 15, 10, 5};

        int [] freqArr= new int[16];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int maxIndex=-1, minIndex=-1;

        //Populating the hash array freqArr.
        for(int i=0;i<arr.length;i++) {
            freqArr[arr[i]]++;
        }

        // Finding the maximum occured element.
        for(int i=0;i<freqArr.length;i++) {
            if(max<freqArr[i]) {
                max=freqArr[i];
                maxIndex=i;
            }

            if(freqArr[i]<min && freqArr[i]!=0) {
                min=freqArr[i];
                minIndex=i;
            }
        }

        System.out.println(maxIndex+" occurs max time "+ max);
        System.out.println(minIndex+" occurs min times "+min);
    }
}
