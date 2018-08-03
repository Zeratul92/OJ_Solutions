package codeforces;

import java.io.BufferedInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
Tips:
If the table is empty(number of elements scientists already have is 0), then the answer would be n + m - 1.
For example:
('1' means the elements you already got, and '0' means otherwise)
000
000
You need to get:
111
100
Then you can have:
111
111

So, imagine this:
Firstly, produce any possible new elements with the initial elements.
You can swap the positions of any two rows or columns of the chemical table, and the result won't be changed.
Make the table looks like this, elements you got can be in some 'blocks'.
1100000000
1100000000
0010000000
0001110000
0001110000
0000000110
0000000000
0000000000

Naturally this problem can be turned into a disjoint-set data structure problem.
A 'block' can be treated as a 'set'.
Let the nodes be numbered as 1, 2, 3, ..., n, n + 1, n + 2, n + 3, ..., n + m.
Initially they are disjoint, you need at least n + m - 1 edges to join them all.
For every element, consider it as an edge to join ri and ci.
For example: with element(ri, ci), join node[ri] and node[ci + n].(mind that 1 <= ri <= n < n + 1 <= ci + n <= n + m)

This is the explain:
You got some points at row rx
(rx, cx)
(rx, cy)
you got some points at row ry(ry != rx)
(ry, cx)
You don't have element(ry, cy) yet, but you can produce it with these three elements above.
So as to make these coordinates rx, ry, cx, cy all belong to one set, you need to 'join' these index.
join node[rx] and node[cx + n]
join node[rx] and node[cy + n]
join node[ry] and node[cx + n]
Applying disjoint-set data structure, you have already joint node[ry] and node[cy + n].
After all join operation(traverse all of the elements), count the number of disjoint sets as k, the answer would be k - 1
 */
/**
 * <a href='http://codeforces.com/problemset/problem/1012/B'>http://codeforces.com/problemset/problem/1012/B</a>
 */
public class Problem_1012B {
    /**
     * Find the root node of node[x] in a disjoint-set data structure(using array), and do path compression simultaneously.
     * @param x index
     * @param arr a disjoint-set data structure(using array)
     * @return the parent node of node x(could be itself if this is a root node)
     */
    public static int find(int x, int[] arr) {
        if (arr[x] == x)
            return x;
        arr[x] = find(arr[x], arr);
        return arr[x];
    }

    /**
     * Join two nodes(indexed x and y) in a disjoint-set data structure(using array)
     * @param x node with index x
     * @param y node with index y
     * @param arr disjoint-set data structure(using array)
     */
    public static void join(int x, int y, int[] arr) {
        int a = find(x, arr);
        int b = find(y, arr);
        if (a != b)
            arr[a] = b;
    }

    /**
     * Initialize a disjoint-set data structure(using array) with every node as a root node.
     * @param size number of the nodes
     * @return an array {0, 1, 2, ..., size - 1}
     */
    public static int[] initDisjointSet(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            int[] a = initDisjointSet(n + m + 1);
            for (int i = 0; i < q; i++) {
                int ri = in.nextInt();
                int ci = in.nextInt() + n;
                join(ri, ci, a);
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= n + m ; i++) {
                set.add(find(a[i], a));
            }
            System.out.println(set.size() - 1);
        }
    }
}

/*
13 17 20
6 14
5 16
2 1
11 6
4 10
4 15
8 14
2 11
10 6
5 11
2 4
4 8
2 10
1 13
11 13
2 5
7 13
9 7
2 15
8 11

4 3 6
1 2
1 3
2 2
2 3
3 1
3 3

 */