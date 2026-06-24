package ArrayHard;

//Merge two sorted arrays without extra space in place- non-descending order.
// [-5,-2,4,5,0,0,0] [-3,1,8]
// output: [-5,-3,-2,1,4,5,8]

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {0, 2, 6, 8, 9};

        brute(nums1, nums2);
        System.out.println("************");
        optimal1(nums1, nums2);

    }

    public static void brute(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];

        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while(p1<nums1.length && p2<nums2.length) {
            if(nums1[p1]<nums2[p2]) {
                result[i]=nums1[p1];

                i++;
                p1++;
            }
            else{
                result[i]=nums2[p2];
                i++;
                p2++;
            }
        }

        while(p1<nums1.length) {
            result[i]=nums1[p1];
            i++;
            p1++;
        }

        while(p2<nums2.length) {
            result[i]=nums2[p2];
            i++;
            p2++;
        }

        for(int j=0;j<result.length;j++) {
            System.out.print(result[j]+" ");
        }
    }

    public static void optimal1(int[] nums1, int[] nums2) {
        /**
         * APPROACH:
         *          Our insight comes from the fact that these two arrays are sorted.
         *          We harness this fact.
         *          Since, we want nums1 and nums2 in sorted order: our objective is nums1 carry the
         *          lightweight elements and nums2 carry the heavy weight elements.
         *
         *          So, we start with the end of nums1: pointer left.
         *          And start with the beginning of nums2 : pointer right(since light elements are sitting at the start)
         *
         *          we compare if nums1[left]>nums2[right]: if yes-> swap them and move on.
         *          if no: notice that nums2[right] will itself be heavier than all on left so break out of loop.
         *
         *          The last step is individually sorting the nums1 and nums2 itself.
         *
         *          TIME COMPLEXITY: O(MIN(N,M))+O(NLOGN)+O(MLOGM)
         *          SPACE COMPLEXITY:O(1)
         */
        int left=nums1.length-1;
        int right=0;

        while(left>=0 && right<nums2.length) {
            if(nums1[left]>nums2[right]) {
                int temp = nums1[left];
                nums1[left]=nums2[right];
                nums2[right]=temp;

                left--;
                right++;
            }
            else{
                break;
            }
        }

        //sorting our arrays.
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int i=0;i<nums1.length;i++) {
            System.out.print(nums1[i]+" ");
        }


        for(int i=0;i<nums2.length;i++) {
            System.out.print(nums2[i]+" ");
        }


    }
}
