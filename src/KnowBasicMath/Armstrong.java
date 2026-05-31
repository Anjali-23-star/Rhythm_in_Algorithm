public class Armstrong {
    public static void main(String [] args) {
        int N = 371;
        int sum = 0, temp =0;

        temp = N;
        while(temp>0) {
            int rem = temp%10;
            sum += Math.pow(rem, 3);
            temp/=10;
        }
        if(N == sum) {
            System.out.println(sum+" is an armstrong.");
        }
    }
}
