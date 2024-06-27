import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();

        // 중위 표기식을 후위 표기식으로 변환하여라
        // 스택을 활용하는거였다는것만 기억난다
        StringBuilder sb = new StringBuilder();

        // 연산자는 +, -, *, /, (, )
        char[] chars = line.toCharArray();
        Stack<Character> operations = new Stack<>();

        for (char c : chars) {
            switch (c) {
                case '+':
                case '-':
                    while (!operations.isEmpty() && operations.peek() != '(') {
                        sb.append(operations.pop());
                    }
                    operations.push(c);
                    break;
                case '*':
                case '/':
                    while (!operations.isEmpty() && operations.peek() != '(' && (operations.peek() == '*' || operations.peek() == '/')) {
                        sb.append(operations.pop());
                    }
                    operations.push(c);
                    break;
                case '(':
                    operations.push(c);
                    break;
                case ')':
                    while (!operations.isEmpty() && operations.peek() != '(') {
                        sb.append(operations.pop());
                    }
                    operations.pop();
                    break;
                default:
                    sb.append(c);
            }
        }
        while (!operations.isEmpty()) {
            sb.append(operations.pop());
        }
        System.out.println(sb);
    }
}