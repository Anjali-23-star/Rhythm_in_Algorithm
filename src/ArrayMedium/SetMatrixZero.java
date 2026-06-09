package ArrayMedium;

import java.util.Arrays;

// Given a matrix if an element in the matrix is 0 then set its entire row and col to 0.
public class SetMatrixZero {
    public static void main(String[] args) {

        //int[][] arr = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] arr1 = {{1,1,1,1}, {1,0,1,1}, {1,1,0,1}, {1,0,0,1}};
        //brute(arr);
        better(arr1);
    }

    public static void brute(int[][] arr) {
        /**
         * APPROACH:
         *           WHY? We can't blindly turn every col and row to 0 because that will then mutate the array
         *           and we will turn 0 that too which was intitally not zero.
         *
         *           1. So, we instead mark the element as -1.
         *           2. Then we mark it again as 0.
         *
         *           TIME COMPLEXITY: O(N3)
         *
         */
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                if(arr[i][j]==0) {
                    markRow(i,arr);
                    markCol(j,arr);
                }
            }
        }

        replaceWith0(arr);
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
    }

    public static void markRow(int i, int[][]arr) {
        // For that row, make all the col -1.
        for(int j=0;j<arr[i].length;j++) {
            arr[i][j]=-1;
        }
    }

    public static void markCol(int j, int[][]arr){
        // For that col, make all the row -1.
        for(int i=0;i<arr.length;i++) {
            arr[i][j]=-1;
        }
    }

    public static void replaceWith0(int[][]arr) {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                if(arr[i][j]==-1) {
                    arr[i][j]=0;
                }
            }
        }
    }


    public static void better(int[][] arr) {
        /**
         * APPROACH:
         *           INSIGHT: Instead of marking currently to 0 and distort the array with false reading of 0 for traversal,
         *                    we mark the cols and rows which are to be made 0.
         *                    Then, after all the markings, we at last mark them to 0.
         *                    This prevents newly created zeros from affecting future traversal.
         *
         *                    1. We take 2 arrays. arr1 of col size(to mark cols containing 0)
         *                                         arr2 of row size(to mark rows containing 0)
         *                    2. We iterate over the array and update the value of respective array to 1 whoever we want to mark as 0 at last.
         *
         *            TIME COMPLEXITY:o(N*M)+O(N*M)~O(N*M)
         *            SPACE COMPLEXITY: O(N)+O(M)
         */

        int[] rowArr=new int[arr.length];
        int[] colArr = new int[arr[0].length];

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(arr[i][j]==0) {
                    rowArr[i]=1;
                    colArr[j]=1;
                }
            }
        }

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(rowArr[i]==1 || colArr[j]==1) {
                    arr[i][j]=0;
                }
            }
        }

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
    }

}
