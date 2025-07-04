package Array;

import java.util.ArrayList;
import java.util.List;

public class PS60 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fizzBuzz(n));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                String strNumber = String.valueOf(i);
                list.add(strNumber);
            }
        }
        return list;
    }
}
