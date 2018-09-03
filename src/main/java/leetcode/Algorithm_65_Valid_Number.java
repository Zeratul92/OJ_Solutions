package leetcode;


public class Algorithm_65_Valid_Number {
    public boolean isNumber(String s) {
        return java.util.regex.Pattern.matches("^[+,-]?(\\d+\\.?|\\d*\\.\\d+)([E,e][+,-]?\\d+)?$", s.trim());
    }

    public static void main(String[] args) {
        Algorithm_65_Valid_Number s = new Algorithm_65_Valid_Number();
        System.out.println(s.isNumber("1.23"));
        System.out.println(s.isNumber("001.23"));
        System.out.println(s.isNumber("12 3"));
        System.out.println(s.isNumber("12.3e4"));
    }
}
