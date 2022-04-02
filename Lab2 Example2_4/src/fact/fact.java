package fact;

public class fact {
    public static int fact(int n) {
        int result;
        if (n == 1) return 1;
        else {
            result = fact(n - 1) * n;
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(" ");
        int result = fact(5);
        System.out.println(result);
    }
}