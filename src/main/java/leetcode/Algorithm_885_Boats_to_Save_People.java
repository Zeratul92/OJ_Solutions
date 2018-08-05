package leetcode;

import java.util.Arrays;

/**
 * Created by Zeratul on 2018/8/5.
 */
public class Algorithm_885_Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (i == j) {
                ans++;
                break;
            }
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
                ans++;
                continue;
            }
            j--;
            ans++;
        }

        return ans;
    }
    public static void main(String[] args) {
        Algorithm_885_Boats_to_Save_People b = new Algorithm_885_Boats_to_Save_People();
        System.out.println(b.numRescueBoats(new int[]{3,5,3,4,2}, 6));
        System.out.println(b.numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(b.numRescueBoats(new int[]{3,2,2,1}, 6));

    }
}
