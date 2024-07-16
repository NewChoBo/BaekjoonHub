import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static List<Position> walls = new ArrayList<>();
    static int minLength = Integer.MAX_VALUE;
    static int N, M;
    static int[][] mover = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input1[0];
        M = input1[1];

        int[][] map = new int[N][];
        int[][] startMap = new int[N][];
        int[][] endMap = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = new int[M];
            startMap[i] = new int[M];
            endMap[i] = new int[M];
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                int num = chars[j] - '0';
                map[i][j] = num;
                if (num == 1) {
                    walls.add(new Position(i, j, 1));
                }
            }
        }

        // 출발지점은 0, 0 - 도착지점은 N-1, M-1로 생각하자
        // 출발점에서 출발, 도착점에서 출발 다 꽉꽉 채워둠.
        // 벽 하나씩 없애보면서 두 최솟값의 합 + 1
        bfs(map, startMap, new Position(0, 0, 1));
        bfs(map, endMap, new Position(N - 1, M - 1, 1));

        if (startMap[N - 1][M - 1] != 0 && startMap[N - 1][M - 1] < minLength) minLength = startMap[N - 1][M - 1];
        if (endMap[0][0] != 0 && endMap[0][0] < minLength) minLength = endMap[0][0];

        for (Position wall : walls) {
            int startWeight = Integer.MAX_VALUE;
            int endWeight = Integer.MAX_VALUE;
            for (int[] move : mover) {
                int x = move[0] + wall.x;
                int y = move[1] + wall.y;
                if (x < 0 || y < 0 || x >= N || y >= M) continue;    // 범위 초과
                if (startMap[x][y] != 0 && startWeight > startMap[x][y]) startWeight = startMap[x][y];
                if (endMap[x][y] != 0 && endWeight > endMap[x][y]) endWeight = endMap[x][y];
            }
            if (startWeight == Integer.MAX_VALUE || endWeight == Integer.MAX_VALUE) continue;
            int newWeight = startWeight + endWeight + 1;
            if (newWeight < minLength) minLength = newWeight;
        }
        if(minLength == Integer.MAX_VALUE) minLength = -1;
        System.out.println(minLength);
    }

    static void bfs(int[][] map, int[][] visit, Position startPoint) {
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(startPoint);

        visit[startPoint.x][startPoint.y] = startPoint.weight;
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int weight = position.weight + 1;
            for (int[] move : mover) {
                Position position1 = new Position(position.x + move[0], position.y + move[1], weight);
                if (position1.validPosition(map)) {
                    if (visit[position1.x][position1.y] == 0 || visit[position1.x][position1.y] > position1.weight) {
                        visit[position1.x][position1.y] = position1.weight;
                        queue.offer(position1);
                    }
                }
            }
        }
    }

    static class Position {
        int x, y, weight;

        Position(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        boolean validPosition(int[][] map) {
            if (x < 0 || y < 0 || x >= N || y >= M) return false;   // 범위 이탈
            if (map[x][y] == 1) return false;
            return true;
        }
    }
}