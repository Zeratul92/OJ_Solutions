package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Zeratul on 2018/8/5.
 */
public class Algorithm_880_Decoded_String_at_Index {
    public String decodeAtIndex(String S, int K) {
        int a = -1;
        int b = 0;
        long curLen = 0;

        Deque<Integer> begin = new LinkedList<>();
        Deque<Integer> end = new LinkedList<>();
        Deque<Integer> times = new LinkedList<>();
        Deque<Long> allLen = new LinkedList<>();
        boolean isPreDigit = false;

        for (int i = 1; i <= S.length(); i++) {
            char ch = S.charAt(i - 1);
            if ('2' <= ch && ch <= '9') {
                curLen *= ch - '0';
                if (isPreDigit) {
                    long allLenLast = allLen.pollLast() * (ch - '0');
                    curLen = allLenLast;
                    allLen.add(allLenLast);
                    int t = times.pollLast() * (ch - '0');
                    times.add(t);
                } else {
                    isPreDigit = true;
                    begin.add(a);
                    end.add(b);
                    a = -1;
                    allLen.add(curLen);
                    times.add(ch - '0');
                }
                System.out.println(begin.getLast() + " " + end.getLast() + " " + times.getLast() + " " + allLen.getLast());
            } else {
                if (a == -1) {
                    a = i;
                }
                b = i;
                curLen++;
                isPreDigit = false;
            }
            if (curLen >= K) {
//                System.out.println("a = " + a);
                if (a != -1) {
                    return ch + "";
                }
                long idx = K;
                System.out.println("idx = " + idx);
                while (true) {
                    idx = idx % (allLen.pollLast() / times.pollLast());
                    System.out.println("idx = " + idx);
                    if (idx == 0) {
                        return "" + S.charAt(end.getLast() - 1);
                    }
                    if (allLen.isEmpty()) {
                        return "" + S.charAt((int) (idx - begin.getLast()));
                    }
                    if (idx <= allLen.getLast()) {
                        begin.pollLast();
                        end.pollLast();
                    } else {
                        return "" + S.charAt((int) (idx - allLen.getLast() - 2 + begin.getLast()));
                    }
                }


            }
        }

//        System.out.println(begin);
//        System.out.println(end);
//        System.out.println(times);
//        System.out.println(allLen);

        return "";
    }

    public static void main(String[] args) {
        Algorithm_880_Decoded_String_at_Index d = new Algorithm_880_Decoded_String_at_Index();

        System.out.println(d.decodeAtIndex("a2b3c4d5e6f7g8h9", 9));
        System.out.println(d.decodeAtIndex("leet2code3skr4", 100));
        System.out.println(d.decodeAtIndex("leet2code3", 10));
        System.out.println(d.decodeAtIndex("ha22", 5));
        System.out.println(d.decodeAtIndex("a23", 6));
    }
}
