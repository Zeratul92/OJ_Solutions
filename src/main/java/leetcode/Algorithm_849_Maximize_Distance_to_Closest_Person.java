package leetcode;

public class Algorithm_849_Maximize_Distance_to_Closest_Person {
    public int maxDistToClosest(int[] seats) {
        int ans = 1;
        int last = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                continue;
            }
            if (last == -1) {
                last = -i;
            }
            if (i - last > 1) {
                ans = Math.max(ans, (i - last) / 2);
            }

            last = i;
        }

        if (last != seats.length - 1) {
            ans = Math.max(ans, seats.length - 1 - last);
        }
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_849_Maximize_Distance_to_Closest_Person s = new Algorithm_849_Maximize_Distance_to_Closest_Person();
        int[] a = { 0, 0, 0, 0, 0, 1};
        System.out.println(s.maxDistToClosest(a));
    }
}
