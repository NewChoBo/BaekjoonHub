import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int R, C;
    static char[][] map;
    static int max = 1;

    static int[][] mover = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = input1[0];
        C = input1[1];
        map = new char[R][];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Point start = new Point(0, 0);
        start.charCnt[map[0][0] - 'A'] = true;
        Stack<Point> pointQueue = new Stack<>();
        pointQueue.add(start);

        while (!pointQueue.isEmpty()) {
            Point point = pointQueue.pop();
            for (int[] move : mover) {
                int x = move[0] + point.x;
                int y = move[1] + point.y;
                if (!isValid(x, y)) continue;

                int index = map[x][y] - 'A';
                if (point.charCnt[index]) continue;

                Point newPoint = new Point(x, y, point.charCnt);
                newPoint.charCnt[index] = true;
                pointQueue.add(newPoint);
                int cnt = 0;
                for (boolean flag : newPoint.charCnt) {
                    if (flag) cnt++;
                }
                if (cnt > max) max = cnt;
            }
        }

        System.out.println(max);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    static class Point {
        int x, y;
        boolean[] charCnt;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.charCnt = new boolean[26];
        }

        Point(int x, int y, boolean[] charCnt) {
            this.x = x;
            this.y = y;
            this.charCnt = charCnt.clone();
        }
    }
}