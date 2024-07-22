import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input1[0];
        M = input1[1];
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 빙산 Queue 삽입
        Queue<Point> pointQueue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    pointQueue.add(new Point(i, j, map[i][j]));
                }
            }
        }

        int day = 0;
        while (!pointQueue.isEmpty()) {
            if(countSeperated(pointQueue.peek()) != pointQueue.size()) {
                System.out.println(day);
                return;
            }

            day++;
            Queue<Point> tempQueue = new ArrayDeque<>();
            while (!pointQueue.isEmpty()) {
                Point point = pointQueue.poll();
                point.size -= point.getZeros();
                    tempQueue.add(point);
            }

            while (!tempQueue.isEmpty()) {
                Point point = tempQueue.poll();
                if(point.size < 0) point.size = 0;
                map[point.x][point.y] = point.size;
                if(point.size > 0) pointQueue.add(point);
            }
        }
        System.out.println(0);
    }

    static int countSeperated(Point point) {
        Queue<Point> pointQueue = new ArrayDeque<>();
        boolean[][] visitMap = new boolean[N][];
        for (int i = 0; i < visitMap.length; i++) {
            visitMap[i] = new boolean[M];
        }
        pointQueue.add(point);
        visitMap[point.x][point.y] = true;
        int cnt = 1;

        while (!pointQueue.isEmpty()) {
            Point point1 = pointQueue.poll();
            for (int[] move : Point.mover) {
                int x = point1.x + move[0];
                int y = point1.y + move[1];

                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (!visitMap[x][y] && map[x][y] != 0) {
                    visitMap[x][y] = true;
                    cnt++;
                    pointQueue.add(new Point(x, y, 0));
                }
            }
        }


        return cnt;
    }

    static class Point {
        int x, y;
        int size;

        static final int[][] mover = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Point(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        int getZeros() {
            int cnt = 0;
            for (int[] move : mover) {
                int x = this.x + move[0];
                int y = this.y + move[1];

                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (map[x][y] == 0) cnt++;
            }
            return cnt;
        }
    }
}