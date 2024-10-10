import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int[][] mover = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1은 이동 가능, 0은 이동 불가. 1, 1에서 출발하여 N, M으로 이동할 때 지나야 하는 최소 칸 수
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    map[i][j] = true;
                }
            }
        }

        // 이동 횟수 초기화용 map 생성
        int[][] cntMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cntMap[i], Integer.MAX_VALUE);
        }

        // map 순회하며 값 확인 시작
        Queue<int[]> queue = new ArrayDeque<>();
        cntMap[0][0] = 1;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int currentX = point[0];
            int currentY = point[1];

            for (int[] move : mover) {
                int x = point[0] + move[0];
                int y = point[1] + move[1];
                if (x < 0 || y < 0 || x >= N || y >= M || !map[x][y] || cntMap[x][y] <= cntMap[currentX][currentY] + 1) {
                    continue;
                }
                cntMap[x][y] = cntMap[currentX][currentY] + 1;
                queue.add(new int[]{x, y});
            }
        }

        System.out.println(cntMap[N - 1][M - 1]);
    }
}