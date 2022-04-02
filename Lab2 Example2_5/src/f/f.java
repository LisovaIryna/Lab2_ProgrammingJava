package f;

public class f {

    // use of recursive method
    public static int f(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return f(n - 2) + f(n - 1);
        }
    }

    // bypass the recursive call tree
    public static int f2(int n){
        if (n == 1 || n == 2)
        {
            return 1;
        }
        int last1 = 1;
        int last2 = 1;
        int cur = 0;
        for (int i = 3; i <= n; ++i) {
            cur = last1 + last2;
            last2 = last1;
            last1 = cur;
        }
        return cur;
    }

        public static void main(String[] args) {

        System.out.println("");
        int result = f(8);
        System.out.println("Use of recursive method:");
        System.out.println(result);

        System.out.println(" ");
        int result2 = f2(8);
        System.out.println("Bypass the recursive call tree:");
        System.out.println(result2);
    }
}