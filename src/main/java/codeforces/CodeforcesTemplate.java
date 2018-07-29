package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * A template for codeforces java(1.8) submit.
 * Use Scanner to get standard input.
 * Use System.out to output.
 * The top line 'package ...' needs to be neglected before submit.
 */
public class CodeforcesTemplate {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            String line = in.nextLine();
            int a = in.nextInt();
            System.out.println(line);
            System.out.println(String.format("%.7f", 0.0));
        }
    }
}
