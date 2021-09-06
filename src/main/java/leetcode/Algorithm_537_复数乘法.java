package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_537_复数乘法 {

    public String complexNumberMultiply(String num1, String num2) {

        String[] num1str = num1.split("\\+");
        String[] num2str = num2.split("\\+");
        int realPart1 = Integer.parseInt(num1str[0]);
        int imaginaryPart1 = Integer.parseInt(num1str[1].substring(0, num1str[1].length() - 1));
        int realPart2 = Integer.parseInt(num2str[0]);
        int imaginaryPart2 = Integer.parseInt(num2str[1].substring(0, num2str[1].length() - 1));
        int retRealPart = realPart1 * realPart2 - imaginaryPart1 * imaginaryPart2;
        int retImaginaryPart = realPart1 * imaginaryPart2 + imaginaryPart1 * realPart2;

        return retRealPart + "+" + retImaginaryPart + "i";
    }

    public static void main(String[] args) {

        Algorithm_537_复数乘法 solution = new Algorithm_537_复数乘法();


        System.out.println(solution.complexNumberMultiply("1+1i", "1+1i"));
    }
}
