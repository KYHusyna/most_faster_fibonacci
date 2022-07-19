import java.util.ArrayList;

public class Main {
    static long a[] = new long[101];

    public static void main(String[] args) {

        calculate_method(1, 30);
        calculate_method(2, 100);
        calculate_method(3, 100);

        System.out.println("Third method is faster");
    }

    private static void calculate_method(int type, int size) {
        long miliseconds_start, miliseconds_finish;
        int n1 = 0;
        double elapsed = 0;

        switch (type) {
            case 1:
                System.out.println("---------------First method---------------");
                break;
            case 2:
                System.out.println("---------------Second method---------------");
                break;
            case 3:
                System.out.println("---------------Third method---------------");
                break;
        }

        miliseconds_start = System.nanoTime();
        while (n1 <= size) {
            if (n1 % 10 == 0) {

                switch (type) {
                    case 1:
                        System.out.println("For " + n1 + " fibonacci number=" + f(n1));
                        break;
                    case 2:
                        System.out.println("For " + n1 + " fibonacci number=" + Fib(n1));
                        break;
                    case 3:
                        System.out.println("For " + n1 + " fibonacci number=" + Fibonacci(n1));
                        break;
                }

                miliseconds_finish = System.nanoTime();
                elapsed = miliseconds_finish - miliseconds_start;
                System.out.println("Wasted time:" + elapsed / 1000000 + " mili-seconds");
            }
            n1++;
        }
        System.out.println("---------------------------------");

    }

    private static long f(int n) {
        if (n < 2) {
            return 1;
        } else return (f(n - 1) + f(n - 2));
    }

    private static long Fib(int n) {
        if (a[n] == 0) {
            if (n == 0 || n == 1) {
                a[n] = 1;
            } else {
                a[n] = Fib(n - 1) + Fib(n - 2);
            }
        }
        return a[n];
    }

    private static long Fibonacci(int n) {
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }

        return a[n];
    }
}