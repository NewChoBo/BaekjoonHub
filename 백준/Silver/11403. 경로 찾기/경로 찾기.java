import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 가중치 없는 방향 그래프 G
        // 모든 정점 (i, j), i->j 길이 양수 경로 있나?
        // 점 개수 N
        // N개의 줄 그래프의 인접 행렬 (i번째 줄의 j번째 숫자가 1인 경우 i에서 j로 가는 간선 존재. 0이면 없음)
        // i번째줄의 i번째 숫자는 항상 0이다.
        // i에서 j로 가는 길이가 양수인 경로가 있으면 i번째줄의 j번째 수를 1로, 없으면 0으로 출력한다.
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int[] connections = new int[N];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int num = queue.poll();
                int[] line = map[num];
                for (int j = 0; j < N; j++) {
                    if (line[j] == 0 || connections[j] != 0) continue;
                    connections[j] = 1;
                    queue.add(j);
                }
            }
            for(int num : connections) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}