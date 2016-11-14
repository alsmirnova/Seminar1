package seminar1;

import seminar1.collections.LinkedStack;

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
public class ParenthesesSequenceExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    // sequence = "()()" | "(({}[]))[[[" | "{}" | ...
    private static boolean isBalanced(String sequence) {
        /* TODO: implement it */
        char[] stream = sequence.toCharArray();
        LinkedStack list = new LinkedStack();
        for (int i = 0; i < stream.length; i++) {
            if (stream[i] == LEFT_BRACE || stream[i] == LEFT_PAREN || stream[i] == LEFT_BRACKET) {
                list.push(stream[i]);
            }
        else if (stream[i]== RIGHT_BRACE || stream[i]== RIGHT_PAREN || stream[i]== RIGHT_BRACKET) {
            if (list.size()!=0) {
                switch (stream[i]) {
                    case RIGHT_BRACE:
                        if (list.iterator().next().equals(LEFT_BRACE)) list.pop();
                        break;
                    case RIGHT_BRACKET:
                        if (list.iterator().next().equals(LEFT_BRACKET)) list.pop();
                        break;
                    case RIGHT_PAREN:
                        if (list.iterator().next().equals(LEFT_PAREN)) list.pop();
                }
            }
            else return false;
        }
        }
        if (list.size()==0) return true;
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
