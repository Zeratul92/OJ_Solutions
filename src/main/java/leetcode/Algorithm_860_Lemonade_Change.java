package leetcode;

public class Algorithm_860_Lemonade_Change {

    public boolean lemonadeChange(int[] bills) {
        int cash5 = 0, cash10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                cash5++;
            } else if (bill == 10) {
                if (cash5 <= 0) {
                    return false;
                }
                cash5--;
                cash10++;
            } else {
                if (cash10 > 0 && cash5 > 0) {
                    cash5--;
                    cash10--;
                    continue;
                }
                if (cash5 >= 3) {
                    cash5 -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Algorithm_860_Lemonade_Change s = new Algorithm_860_Lemonade_Change();

    }
}
