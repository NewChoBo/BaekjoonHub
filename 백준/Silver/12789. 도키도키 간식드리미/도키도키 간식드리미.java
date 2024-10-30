import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(getResult(queue) ? "Nice" : "Sad");
    }

    static boolean getResult(Queue<Integer> queue) {
        int N = queue.size();
        Stack<Integer> stack = new Stack<>();

        int current = 1;
        while (true) {
            if (current == N) return true;
            if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
                current++;
                continue;
            }
            if (!queue.isEmpty()) {
                int value = queue.poll();
                if (value == current) {
                    current++;
                    continue;
                }
                stack.add(value);
                continue;
            }
            return false;
        }
    }
}