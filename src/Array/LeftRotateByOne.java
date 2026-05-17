package Array;

// rotate array to the left
// [1,2,3,4,5]=>[2,3,4,5,1]

public class LeftRotateByOne {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        bruteForce(arr);

        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] +" ");
        }
    }

    public static void bruteForce(int[] a) {

        int first = a[0];

        for(int j=1;j<a.length;j++) {
            a[j-1]=a[j];
        }

        a[a.length-1] = first;
    }
}
