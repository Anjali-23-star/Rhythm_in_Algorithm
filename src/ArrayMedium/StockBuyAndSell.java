package ArrayMedium;

// You are given prices[i] of stock for days[i]. Find the maximum profit earned if one buys it at day[i]
// and sells it at day[i']. If profit<0-> return 0.
public class StockBuyAndSell {
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        //System.out.println(brute(prices));
        System.out.println(optimal(prices));

    }

    public static int brute(int[] arr) {
        /**
         * APPROACH:
         *           1. Track all pairs and keep score of the maximum difference.
         *           TIME COMPLEXITY: O(N2)
         *           SPACE COMPLEXITY: O(1)
         */
        int profit=0;

        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
               if(arr[j]-arr[i]>0) {
                   profit = Math.max(profit, arr[j]-arr[i]);
               }
            }
        }

        return profit;
    }

    public static int optimal(int[] arr) {
        /**
         * APPROACH:
         *          1. We assume that the current value is selling price of stock.
         *          2. We go back till arr[selling_price-1] and find the best buying price for
         *             that selling price.
         *             i.e. we find the minimum price value.
         *             profit=selling_price-buying price.
         *
         *             We store it in some variable.
         *           3. Keep on traversing till we find the maximum profit value.
         *
         *           TIME COMPLEXITY: O(N)
         *           SPACE COMPELXITY: O(1)
         */

        int profit=0,j=0, min=arr[0];
        for(int i=0;i<arr.length;i++) {
            profit=Math.max(profit, arr[i]-min);

            min=Math.min(min, arr[i]);
        }

        return profit;
    }


}
