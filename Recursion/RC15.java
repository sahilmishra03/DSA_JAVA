package Recursion;

public class RC15 {
    public static String[] keypad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxzy" };

    public static void printComb(String str, int idx, String combination) {
        if (idx == str.length()) {
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            printComb(str, idx + 1, combination + mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str = "23";
        printComb(str, 0, "");
    }
}