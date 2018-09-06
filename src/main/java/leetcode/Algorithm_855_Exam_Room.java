package leetcode;


import java.util.ArrayList;
import java.util.List;

class ExamRoom {
    List<Integer> list;
    int n;
    public ExamRoom(int N) {
        list = new ArrayList<>();
        n = N;
    }

    public int seat() {
        if (list.size() == 0) {
            list.add(0);
            return 0;
        }
        int maxDis = Math.max(list.get(0), n - 1 - list.get(list.size() - 1));

        for (int i = 0; i < list.size() - 1; i++) {
            maxDis = Math.max(maxDis, (list.get(i + 1) - list.get(i)) >> 1);
        }
        if (maxDis == list.get(0)) {
            list.add(0, 0);
            return 0;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (maxDis == (list.get(i + 1) - list.get(i)) >> 1) {
                int idx = (list.get(i + 1) + list.get(i)) >> 1;
                list.add(i + 1, idx);
                return idx;
            }
        }
        list.add(n - 1);
        return n - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == p) {
                list.remove(i);
                return;
            }
        }
    }
}

public class Algorithm_855_Exam_Room {



    public static void main(String[] args) {
        Algorithm_855_Exam_Room s = new Algorithm_855_Exam_Room();
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat();
        System.out.println(examRoom.list);
        examRoom.seat();
        System.out.println(examRoom.list);
        examRoom.seat();
        System.out.println(examRoom.list);

        examRoom.leave(0);
        System.out.println(examRoom.list);
        examRoom.leave(4);
        System.out.println(examRoom.list);

        examRoom.seat();
        System.out.println(examRoom.list);
        examRoom.seat();
        System.out.println(examRoom.list);
        examRoom.seat();
        System.out.println(examRoom.list);
        examRoom.seat();
        System.out.println(examRoom.list);
        examRoom.seat();
        System.out.println(examRoom.list);
        examRoom.seat();
        System.out.println(examRoom.list);
    }
}
