package BinarySearchOnAnswers;

// find Nth root of M. eg. N=3, M=27: cube(27)=3. otherwise, return -1.
public class NthRoot {
    public static void main(String[] args) {
        int n = 3, m = 27;

        System.out.println(brute(m, n));
        System.out.println(optimal(m, n));
    }

    public static int brute(int m, int n) {
        int answer=0;
        int k;

        for(int i=0;i<=m;i++) {
            k=n;
            answer = 1;

            while(k>0) {
                answer*=i;
                k--;
            }

            if(answer == m) {
                answer = i;
                break;
            }
            else if(answer>m) {
                answer = -1;
                break;
            }
        }

        return answer;

    }
    public static int optimal(int m, int n) {
        /**
         * APPROACH:  Suppose n==3.
         *            1X1X1 = 1
         *            2X2X2 = 8
         *            3X3X3 = 9
         *            .... notice something?
         *            The answer is monotonically increasing.
         *            In such cases, we can apply binary search.
         */
        int low = 1;
        int high = m;
        int answer = -1;

        while(low<=high) {
            int mid = low+(high-low)/2;

            if(Math.pow(mid,n)==m) {
                return mid;
            }

            else if(Math.pow(mid,n)>m) {
                //search in the lower branch.
                high = mid-1;
            }

            else {
                low = mid+1;
            }
        }
     return answer;
    }
}

