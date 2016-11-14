package seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. пустая строка — правильная скобочная последовательность;
 * 2. правильная скобочная последовательность,
 * взятая в скобки одного типа — правильная скобочная последовательность;
 * 3. правильная скобочная последовательность,
 * к которой приписана слева или справа правильная скобочная последовательность
 * — тоже правильная скобочная последовательность.
 */
public class ParenthesesSequence {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';

    // sequence = "()()" | "((((" | ")()(" | ...
    private static boolean isBalanced(String sequence) {
        /* TODO: implement it */
        char[] cc = sequence.toCharArray();
        int z = cc.length;
        int count = 0;
        for (int j = 0; j < z; j++) {
            if (cc[j] == LEFT_PAREN) {
                count++;
            } else if (cc[j] == RIGHT_PAREN) {
                count--;
            }
            if (count < 0) return false;
        }
        if (count == 0) return true;
        else return false;

    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(isBalanced(sequence) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
