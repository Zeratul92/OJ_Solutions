package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Algorithm_68_Text_Justification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int tempLen = -1;
        int start = 0, end = 0;
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (tempLen + 1 + words[i].length() > maxWidth) {
                if (start == end) {
                    StringBuilder sb = new StringBuilder(words[start]);
                    addSpace(sb, maxWidth - words[start].length());
                    ret.add(sb.toString());
                } else {
                    int wordsLen = 0;
                    for (int idx = start; idx <= end; idx++) {
                        wordsLen += words[idx].length();
                    }
                    int spaceCnt = (maxWidth - wordsLen) / (end - start);
                    int moreSpace = (maxWidth - wordsLen) % (end - start);

                    StringBuilder sb = new StringBuilder(words[start]);
                    for (int idx = 0; idx < end - start; idx++) {
                        addSpace(sb, idx < moreSpace ? spaceCnt + 1 : spaceCnt);
                        sb.append(words[start + 1 + idx]);
                    }
                    ret.add(sb.toString());
                }
                tempLen = words[i].length();
                start = i;
                end = i;
            } else {
                tempLen += 1 + words[i].length();
                end = i;
            }
        }

        StringBuilder lastLine = new StringBuilder();
        int lastLineLen = 0;
        for (int i = start; i <= end; i++) {
            if (i != start) {
                lastLine.append(' ');
                lastLineLen++;
            }
            lastLine.append(words[i]);
            lastLineLen += words[i].length();
        }
        addSpace(lastLine, maxWidth - lastLineLen);
        ret.add(lastLine.toString());
        return ret;
    }

    private void addSpace(StringBuilder sb, int spaceCnt) {
        for (int i = 0; i < spaceCnt; i++) {
            sb.append(' ');
        }
    }

    public static void main(String[] args) {
        Algorithm_68_Text_Justification s = new Algorithm_68_Text_Justification();
//        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};

        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        List<String> list = s.fullJustify(words, 22);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
