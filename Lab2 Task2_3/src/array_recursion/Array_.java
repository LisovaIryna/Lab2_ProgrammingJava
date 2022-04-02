package array_recursion;
import java.util.Scanner;

public class Array_ {

    // Recursive method for array input
    public static void Input_ArrayNumber(int numbers[], int i, int n) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        if (i >= n)
            return;
        numbers[i] = sc.nextInt();
        Input_ArrayNumber(numbers, i + 1, n);
    }

    // Recursive method for array output
    public static void Output_ArrayNumber(int numbers[], int i, int n) {
        if (i >= n)
            return;
        System.out.println(numbers[i]);
        Output_ArrayNumber(numbers, i + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Enter the number of numbers you want to enter:");
        int n = sc.nextInt();
        if (n < 1){
            System.out.println("Number of items must be greater than 0.");
        }
        else {
            int numbers[] = new int[n];
            System.out.println("Enter an array of numbers:");
            Input_ArrayNumber(numbers, 0, n);
            System.out.println("Output array:");
            Output_ArrayNumber(numbers, 0, n);
        }
    }
}