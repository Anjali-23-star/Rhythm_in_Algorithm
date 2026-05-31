public class FibonacciUsingRecursion {
    public static void main(String [] args) {

        fibonacci(5, 0, 1);
    }

    public static void fibonacci(int N, int a, int b) {
        // Base case
        if(N==0) {
            return ;
        }

        System.out.print(a + " ");
        fibonacci(N-1, b, a+b);
 }
}