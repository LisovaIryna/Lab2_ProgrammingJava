package binary;
import java.util.Scanner;

public class Binary {

    public static String toBinary(int n) {
        if (n <= 1 ) {
            return String.valueOf(n);
        }
        return toBinary(n / 2) + String.valueOf(n % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");

        System.out.println("Enter a number:");
        int n = sc.nextInt();
        if (n < 0){
            System.out.println("Error. Number must be greater than 0.");
        }
        else {
            String result = toBinary(n);
            System.out.println("Result (number in binary number system):");
            System.out.println(result);
        }
    }
}