package ArrayHard;

import java.util.ArrayList;

// Given an array of numbers, return the count of reverse pairs. arr[i]>2*arr[j]
// {1,3,2,3,1} answer (3,1) and (3,1).
public class CountReversePairs {
    private static int count;
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        brute(arr);
        System.out.println("*********");
        optimal(arr);
    }

    public static void brute(int[] arr) {
        int count=0;

        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i]>2*arr[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void optimal(int[] arr){
      divide(arr, 0,arr.length);


        System.out.println(count);
    }

    public static void divide(int[] arr, int low, int high) {
        if(low>=high) {
            return;
        }

        int mid = (low+high)/2;

        divide(arr, low, mid);

        divide(arr, mid+1, high);

        merge(arr, low, mid, high);


    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = arr[low];
        int right = mid+1;

        final var temp = new ArrayList<Integer>();

        while(left<=right) {
            if(arr[left]<arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else if (arr[left]>2*arr[right]+1){
                count+=mid-left+1;
                right++;
            }
        }
        while(left<mid) {
            temp.add(arr[left]);
            left++;
        }
        while(right<high) {
            temp.add(arr[right]);
            right++;
        }

        for(int i=low;i<high;i++) {
            arr[low]=temp.get(i-low);
        }

    }


}
