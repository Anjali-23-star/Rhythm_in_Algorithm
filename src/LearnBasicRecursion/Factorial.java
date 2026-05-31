public class Factorial {
    public static void main(String [] args) {
        // Iterative approach.
        int x = 5;
        int fact = 1;

        while(x>0) {
            fact *= x;
            x= x-1;
        }

        System.out.println("factorial by iteration"+fact);

        /**
        * APPROACH: The stack will go on increasing till it reaches a ceiling with num =0 at which point stack will pop.
         */

        System.out.println("factorial by recursion"+ fact(5));
    }

    // Recursive approach.
    public static int fact(int num) {
        // Handling non negative number.
        if(num <0) {
            throw new IllegalArgumentException("Number must be positive.");
        }
        
        // Base case
        if(num == 0) {
            return 1;
        }

        return num*fact(num-1);
    }
    
}
