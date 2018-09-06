package leetcode;

public class Algorithm_858_Mirror_Reflection {

    public int mirrorReflection(int p, int q) {

        int gcd = gcd(p, q);

        int a = p / gcd;
        int b = q / gcd;
        if (a % 2 == 1 && b % 2 == 1) {
            return 1;
        } else if (a % 2 == 1) {
            return 0;
        } else {
            return 2;
        }
    }

    private  int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Algorithm_858_Mirror_Reflection s = new Algorithm_858_Mirror_Reflection();
        for (int p = 1; p < 10; p++) {
            for (int q = 0; q <= p; q++) {
                System.out.println("p = " + p + ", q = " + q + ": " + s.mirrorReflection(p, q));
            }
        }

    }
}
