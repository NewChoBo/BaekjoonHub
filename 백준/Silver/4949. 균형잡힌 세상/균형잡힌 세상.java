import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input;
        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (char c : input.toCharArray()) {
                if (!flag) break;
                switch (c) {
                    case '(':
                        stack.add(')');
                        break;
                    case '[':
                        stack.add(']');
                        break;
                    case ')':
                    case ']':
                        if (stack.isEmpty() || stack.pop() != c) {
                            flag = false;
                        }
                        break;
                }
            }
            if (flag && stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb);
    }
}