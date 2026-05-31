// Sum of first N numbers.
public class sumToN{
    public static void main(String [] args) {

        System.out.println("sum ="+sumOfNumbers(1, 10));
        
    }
    // A recursive function.
    public static int sumOfNumbers(int current, int N) {
        // Base case
        if(current > N) {
            return 0;
        }

        return current+sumOfNumbers(current+1, N);
    }
}