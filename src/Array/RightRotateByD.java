package Array;

public class RightRotateByD {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7};

        rightRotate(arr, arr.length, 3);

        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void rightRotate(int[] arr, int n, int d) {
        d = d%n;

        rightReverse(arr, 0, n-d-1);
        rightReverse(arr, n-d, n-1);
        rightReverse(arr, 0, n-1);
    }

    public static void rightReverse(int[] arr, int start, int end) {
        while(start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
