import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        int result = 0; // 최종 결과값
        int temp = 1;   // 현재 중첩된 괄호의 배수

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(') {
                stack.push(current);
                temp *= 2; // 괄호가 열릴 때마다 배수를 2배로
            } else if (current == '[') {
                stack.push(current);
                temp *= 3; // 괄호가 열릴 때마다 배수를 3배로
            } else if (current == ')') {
                // 유효성 검사: 스택이 비었거나 짝이 안 맞으면 실패
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                // 바로 직전 문자가 여는 괄호였다면 (= 괄호가 완성된 최소 단위라면)
                if (input.charAt(i - 1) == '(') {
                    result += temp; // 현재까지의 배수를 결과에 더함
                }
                stack.pop();
                temp /= 2; // 괄호가 닫혔으므로 배수를 다시 줄임
            } else if (current == ']') {
                // 유효성 검사
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                // 괄호가 완성된 순간
                if (input.charAt(i - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        // 모든 순회 후 스택이 남아있으면 잘못된 괄호
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}