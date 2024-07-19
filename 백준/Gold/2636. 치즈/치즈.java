import java.io.*;
import java.util.*;

/*
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0

3
5
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[][] map;
    // 0: 깨끗한 공기
    // 1: 치즈
    // 2: 처리한 공기
    // 3: 없어질 치즈

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input1[0];  // 세로
        M = input1[1];  // 가로

        // 아무리 오래 걸려도 100일이 걸리지는 않을 것
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int dayCnt = 0;
        int cheeseCount = 0;
        Queue<Point> air = new ArrayDeque<>();
        air.add(new Point(0, 0));
        while (!air.isEmpty()) {
            Queue<Point> cheeseQueue = getCheese(air);
            if(cheeseQueue.isEmpty()) break;
            dayCnt++;
            cheeseCount = cheeseQueue.size();

            while(!cheeseQueue.isEmpty()) {
                deleteCheeseAndGetAir(cheeseQueue, air);
            }
        }

        System.out.println(dayCnt);
        System.out.println(cheeseCount);
    }

    static Queue<Point> getCheese(Queue<Point> airs) {
        Queue<Point> cheeseQueue = new ArrayDeque<>();
        while (!airs.isEmpty()) {
            Point air = airs.poll();
            List<Point> moveList = air.getMoveList();
            for (Point move : moveList) {
                int value = map[move.x][move.y];
                if (value == 0) {
                    airs.add(move);
                    map[move.x][move.y] = 2;
                } else if (value == 1) {
                    cheeseQueue.add(move);
                    map[move.x][move.y] = 2;
                }
            }
        }
        return cheeseQueue;
    }

    static void deleteCheeseAndGetAir(Queue<Point> cheeseQueue, Queue<Point> airs) {
        while (!cheeseQueue.isEmpty()) {
            Point cheese = cheeseQueue.poll();
            airs.add(cheese);

            List<Point> moveList = cheese.getMoveList();
            for (Point move : moveList) {
                int value = map[move.x][move.y];
                if (value == 0) {
                    airs.add(move);
                    map[move.x][move.y] = 2;
                }
            }
        }
    }

    static class Point {
        static int[][] mover = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int x, y;

        boolean isValid() {
            if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 2) {
                return false;
            }
            return true;
        }

        List<Point> getMoveList() {
            List<Point> moveList = new ArrayList<>();
            for (int[] move : mover) {
                Point point = new Point(x + move[0], y + move[1]);
                if (point.isValid()) moveList.add(point);
            }
            return moveList;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}