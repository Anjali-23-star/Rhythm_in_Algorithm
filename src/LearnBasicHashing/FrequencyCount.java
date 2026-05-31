public class FrequencyCount {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60};
        boolean[] visited = new boolean[arr.length];

        /**
         * APPROACH: 
         *          1. For every occurence of element, mark that place as True.
         *          2. Then only look up the elements that are not true, else continue.
         */
        for(int i=0;i<arr.length;i++) {
            // If the place is already touched once, ignore it-i.e don't look up its value again.
            if(visited[i]) {
                continue;
            }

            int count = 1;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i]==arr[j]) {
                   count++;

                   visited[j] = true;
                }
            }

            System.out.println("arr["+i+"] occurs "+ count+ " times.");
        }
    }
}
