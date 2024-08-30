import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        // 0: 1
        // 1: 1
        // 2: 2
        // 3: 3
        // 4: 5
        // ...
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(1);
        for (int i = 2; i <= N; i++) {
            int num = queue.poll();
            int num2 = queue.peek();
            queue.add((num + num2) % 10007);
        }
        System.out.println(queue.peekLast());
    }
}