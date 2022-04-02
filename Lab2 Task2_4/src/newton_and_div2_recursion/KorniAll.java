package newton_and_div2_recursion;
import java.util.Scanner;
import java.math.BigDecimal;

public class KorniAll {

    // function
    public static double f(double x) {
        return x * x * x + 3 * x * x - 6 * x - 8;
    }

    // function derivative
    public static double prf(double x) {
        return 3 * x * x + 6 * x - 6;
    }

    // CALCULATION OF THE ROOT BY NEWTON'S METHOD
    public static double x_newton(double a, double e) {
        double x = a;
        double razn;

        double xn = x - f(x) / prf(x);
        razn = Math.abs(xn - x);
        x = xn;

        if (razn <= e)
            return x - f(x) / prf(x);
        else
            return x_newton(x, e);
    }

    // CALCULATION OF THE ROOT BY THE METHOD OF DIVISION OF THE INTERCEPT IN HALF
    public static double x_div2(double a, double b, double e) {
        double c = (a + b) / 2;
        if (b - a <= e)
            return c;
        else if (f(a) * f(c) < 0)
            return x_div2(a, c, e);
        else if (f(a) * f(c) > 0)
            return x_div2(c, b, e);
        else
            return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println(" ");
        System.out.println("Enter initial interval values and " + " margin of error");
        // interval must contain all roots
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double e = sc.nextDouble();

        System.out.println(" ");
        // SEPARATION OF ROOTS BY PASSING AN INTERVAL WITH A VARIABLE STEP
        System.out.print("Enter the estimated number of roots → ");
        int kol = sc.nextInt(); // for the cubic equation =3
        double xArray[] = new double[kol]; // an array to store selected roots
        double x2Array[] = new double[kol]; // an array to store selected roots
        int kol_naideno; // the number of roots found during the next pass
        int kol_naideno2; // the number of roots found during the next pass
        double x, y1, y2; // the current value of the x coordinate and function values at the ends of the segment [x, x+h]
        double x2, y3, y4;
        double h = (b - a) / kol; // variable spacing
        double h2 = (b - a) / kol; // variable spacing

        do {
            kol_naideno = 0;
            kol_naideno2 = 0;
            x = a;
            x2 = a;
            while (x < b && x2 < b) {
                y1 = f(x);
                y3 = f(x2);
                y2 = f(x + h);
                y4 = f(x2 + h2);
                if ((y1 * y2 <= 0) && (y3 * y4 <= 0)) {
                    x = x_newton(x, e);
                    x2 = x_div2(x2,x2+h2, e);
                    xArray[kol_naideno] = x;
                    x2Array[kol_naideno] = x2;
                    kol_naideno++;
                    kol_naideno2++;
                }
                x += h;
                x2 += h2;
            }
            h /= 2;
            h2 /= 2;
        } while ((kol > kol_naideno) && (2 * h > e) && (kol > kol_naideno2) && (2 * h2 > e));

        // Output calculated roots in a given format using the BigDecimal class
        System.out.println("Equation roots:");
        System.out.println("Newton method:");
        for (int i = 0; i < xArray.length; i++) {
            System.out.println(new BigDecimal(xArray[i]));
        }
        System.out.println(" ");
        System.out.println("Method of division of the intercept in half:");
        for (int i = 0; i < x2Array.length; i++) {
            System.out.println(new BigDecimal(x2Array[i]));
        }
    }
}