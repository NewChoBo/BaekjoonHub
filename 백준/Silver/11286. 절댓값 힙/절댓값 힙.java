import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    // https://www.acmicpc.net/problem/30802

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        // 절댓값이 가장 작은 수 출력, 같으면 그 값 제거
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt((Integer o) -> Math.abs(o)).thenComparingInt(o -> o));
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(queue.poll());
                }
                sb.append('\n');
            } else {
                queue.add(input);
            }
        }
        System.out.print(sb);
    }
}