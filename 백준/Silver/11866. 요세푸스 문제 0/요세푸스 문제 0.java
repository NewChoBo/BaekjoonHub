import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];
        //K<N, 사람: N명, K가 간격

        //줄 만들기
        List<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        while (!circle.isEmpty()) {
            index = (index + K - 1) % circle.size();
            queue.add(circle.remove(index));
        }

        StringBuilder result = new StringBuilder("<");
        while (!queue.isEmpty()) {
            result.append(queue.poll());
            if (!queue.isEmpty())
                result.append(", ");
        }
        result.append(">");
        bw.write(result.toString());
        bw.flush();
    }
}