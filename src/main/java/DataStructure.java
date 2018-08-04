/**
 *
 */
public class DataStructure {
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


}
