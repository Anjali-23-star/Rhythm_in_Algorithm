package BinarySearchOnAnswers;

// Least capacity to ship packages within D days.
// weights[] = {5,4,5,2,3,4,5,6] , days = 5. answer = 9
public class ShipPackagesInDDays {
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};

        System.out.println(brute(weights, 5));
        System.out.println(optimal(weights, 5));
    }

    public static int brute(int[] arr, int days) {
        /**
         * APPROACH:
         *          We have to figure out what our minimum capacity and maximum capacity of the ship is.
         *
         *          The minimum capacity is the max of the weight. Because if its anything less than that,
         *          we can never ship that parcel.
         *          eg: capacity = 3, then parcel with weight 4 can't ever be shipped.
         *
         *          And the maximum capacity of the ship is the total of weights. sum(arr).
         *          This will result in shipping all parcels in 1 day.
         *
         *          We calcualte the number of days requried for each capacity.
         *          If its less than the given days, then we know our capacity.
         *
         *          Else, we move on to the next capacity.
         *
         *          TIME COMPLEXITY: O((sum-max+1)Xn).
         */
        for(int i = max(arr);i<=sum(arr);i++) {
            int totalDays = daysRequired(arr, i);

            if(totalDays<=days) {
                return i;
            }
        }

        return -1;
    }

    public static int daysRequired(int[] arr, int capacity) {
        int days = 1;
        int load =0;

        for(int i=0;i<arr.length;i++) {
            // if the load exceeds the capacity, increase the day.
           if(load+arr[i]>capacity) {
               days++;
               load = arr[i];
           }
           // else, carry the load on same day.
           else {
               load+=arr[i];
           }
        }

        return days;
    }

    public static int optimal(int[] arr, int days) {
        /**
         * APPROACH: TIME COMPLEXITY: O(log(sum-max+1)*O(N)
         */
        int low = max(arr);
        int high = sum(arr);

        while(low<=high) {
            int mid = low+(high-low)/2;
            int day = daysRequired(arr, mid);

            // if day is under total days, then it is our potential minimum days.
            // However, we will keep on searching the lower branch.
            if(day<=days) {
                high = mid-1;
            }
            // increase the capacity.
            else {
                low = mid+1;
            }
        }
        return low;
    }

    public static int max(int[] arr) {
        int max = 0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]>max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int sum(int[] arr) {
        int sum =0;

        for(int i=0;i<arr.length;i++) {
            sum+=arr[i];
        }

        return sum;
    }


}
