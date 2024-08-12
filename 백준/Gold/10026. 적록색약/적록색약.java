import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char[][] map;
    static int N;
    static int[][] mover = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        // 적록색약이 아닌 사람이 봤을 때 구역 개수와 적록 색약인 사람이 봤을 때의 구역 수 공백으로 구분해 출력
        N = Integer.parseInt(br.readLine());
        // map 생성
        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 일반인 확인
        boolean[][] visitedNormal = getNewVisitMap();
        int cntNormal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedNormal[i][j]) {
                    cntNormal++;
                    bfs(i, j, visitedNormal);
                }
            }
        }

        // 색약 확인
        boolean[][] visitedAbormal = getNewVisitMap();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R';
            }
        }
        int cntAbnormal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedAbormal[i][j]) {
                    cntAbnormal++;
                    bfs(i, j, visitedAbormal);
                }
            }
        }

        System.out.println(cntNormal + " " + cntAbnormal);
    }

    static void bfs(int x, int y, boolean[][] visited) {
        char type = map[x][y];
        visited[x][y] = true;

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int[] move : mover) {
                int newX = point.x + move[0];
                int newY = point.y + move[1];
                if (isValid(newX, newY, visited) && map[newX][newY] == type) {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValid(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y]) return false;
        return true;
    }

    static boolean[][] getNewVisitMap() {
        boolean[][] visitMap = new boolean[N][];
        for (int i = 0; i < N; i++) {
            visitMap[i] = new boolean[N];
        }
        return visitMap;
    }
}