import java.util.Scanner;

public class FibonacciCombined {

    // Recursive method
    static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative (non-recursive) method
    static void fibonacciIterative(int n) {
        int a = 0, b = 1;
        int nextTerm;
        System.out.print(a+","+b+",");

        for(int i=2;i<n;i++){
            nextTerm = a + b;
            a = b;
            b = nextTerm;
            System.out.print(nextTerm+ ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        // Iterative Fibonacci
        fibonacciIterative(n);

        // Recursive Fibonacci
        System.out.print("Recursive: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i));
        }
        System.out.println();
    }
}
