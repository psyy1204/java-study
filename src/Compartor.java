public class Compartor {

    static int max(int a, int b, int c) {
        int max = a;

        if (b > max) max = b;
        if (c > max) max = c;

        return max;
    }

    static int min(int a, int b, int c) {
        int min = a;

        if (b < min) min = b;
        if (c < min) min = c;

        return min;
    }

    static int sum(int a, int b, int c) {
        int sum = a + b + c;

        return sum;
    }

    static int rhq(int a, int b, int c) {
        int rhq = a * b * c;

        return rhq;
    }
}