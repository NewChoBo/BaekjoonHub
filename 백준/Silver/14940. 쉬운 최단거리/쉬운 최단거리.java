import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Queue<int[]> queue = new ArrayDeque<>();
    static int[][] mover = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        int[] startPoint = new int[2];

        map = new int[n][];
        // 0: 못감, 1: 갈 수 있음, 2: 목적지
        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                switch (line[j]) {
                    case 2:
                        startPoint[0] = i;
                        startPoint[1] = j;
                        line[j] = 0;
                        break;
                    case 1:
                        line[j] = -1;
                        break;
                }
            }
            map[i] = line;
        }

        // 각 지점에서 목적지까지의 거리
        // 목적지에서 출발, 자신이 더 작으면 바꿔치기
        // 갈 수 있는 위치는 Integer.MAX_VALUE 해버리면 될 듯?
        queue.offer(startPoint);
        bfs();

        for (int[] line : map) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : line) {
                stringBuilder.append(i).append(" ");
            }
            bw.write(stringBuilder.toString());
            bw.write("\n");
        }
        bw.flush();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] checkPoint = queue.poll();
            int current = map[checkPoint[0]][checkPoint[1]];
            for (int[] move : mover) {
                int x = checkPoint[0] + move[0];
                int y = checkPoint[1] + move[1];
                if (x < 0 || n <= x || y < 0 || m <= y) continue;   // 범위 밖으로 나가면 다음
                int newVal = map[x][y];
                if (newVal == 0) continue;
                if (newVal == -1 || current + 1 < newVal) {
                    map[x][y] = current + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}