import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> bracketStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        boolean isPossible = true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[') {
                bracketStack.push(c);
                valueStack.push(0);
            } else {
                if (bracketStack.isEmpty()) {
                    isPossible = false;
                    break;
                }

                char target = (c == ')') ? '(' : '[';
                int multiplier = (c == ')') ? 2 : 3;

                if (bracketStack.peek() != target) {
                    isPossible = false;
                    break;
                }

                int currentSum = 0;
                while (!valueStack.isEmpty() && valueStack.peek() != 0) {
                    currentSum += valueStack.pop();
                }

                if (!valueStack.isEmpty() && valueStack.peek() == 0) {
                    valueStack.pop();
                }

                int result = (currentSum == 0) ? multiplier : currentSum * multiplier;

                valueStack.push(result);
                bracketStack.pop();
            }
        }

        if (!isPossible || !bracketStack.isEmpty()) {
            System.out.println(0);
        } else {
            int finalResult = 0;
            while (!valueStack.isEmpty()) {
                finalResult += valueStack.pop();
            }
            System.out.println(finalResult);
        }
    }
}