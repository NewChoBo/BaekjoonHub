import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 농약 안쓰고 배추 재배
        // 해충방지 배추 흰지렁이 구입, 흰지렁이 인접 배추 같이 보호됨
        // 몇마리의 배추 흰지렁이가 필요한가?
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            // 1. 땅 초기화 및 배추 심기
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = input[0];
            int N = input[1];
            int K = input[2];
            int[][] map = new int[M][];
            for (int i = 0; i < M; i++) {
                map[i] = new int[N];
            }
            while (K-- > 0) {
                int[] point = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = point[0];
                int y = point[1];
                map[x][y] = 1;
            }

            // 2. 땅 처음부터 순회하며 배추 찾기
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        cnt++;
                        paint(map, new Point(i, j), M, N);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    static void paint(int[][] map, Point start, int M, int N) {
        Queue<Point> queue = new ArrayDeque<>();
        map[start.x][start.y] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int[] move : Point.mover) {
                int x = point.x + move[0];
                int y = point.y + move[1];
                if (x < 0 || y < 0 || x >= M || y >= N) {
                    continue;
                }
                if (map[x][y] == 1) {
                    map[x][y] = 0;
                    queue.add(new Point(x, y));
                }
            }
        }
    }

    static class Point {
        static int[][] mover = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
