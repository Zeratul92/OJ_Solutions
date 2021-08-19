package leetcode;

/*

 */
public class Algorithm_509_斐波那契数 {


    public int fib(int n) {
        int[] f = new int[]{
                0,
                1, 1, 2, 3, 5,
                8, 13, 21, 34, 55,
                89, 144, 233, 377, 610,
                987, 1597, 2584, 4181, 6765,
                10946, 17711, 28657, 46368, 75025,
                121393, 196418, 317811, 514229, 832040};

        return f[n];
    }

    public static void main(String[] args) {

        int[] f = new int[31];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < 31; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        for (int i = 0; i < 31; i++) {
            System.out.print(f[i] + ", ");
        };
        System.out.println();

        Algorithm_509_斐波那契数 solution = new Algorithm_509_斐波那契数();


        System.out.println(solution.fib(12));
    }
}
