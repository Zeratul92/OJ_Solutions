package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * A code template for codeforces java(1.8) submit
 * Use Scanner to get standard input.
 * The top line 'package ...' needs to be deleted before submit.
 */
public class Problem {
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