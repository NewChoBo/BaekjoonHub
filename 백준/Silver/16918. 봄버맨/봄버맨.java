import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static final int[][] mover = new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int R = input1[0];
        int C = input1[1];
        int N = input1[2];

        // 각 칸은 비어있거나 폭탄이 있다
        int second = 0;
        Bomb[][] bombMap = new Bomb[R][];
        for (int i = 0; i < R; i++) {
            char[] input2 = br.readLine().toCharArray();
            bombMap[i] = new Bomb[C];
            for (int j = 0; j < input2.length; j++) {
                if (input2[j] == 'O') {
                    bombMap[i][j] = new Bomb(i, j, second);
                }
            }
        }

        // 짝수 초에는 설치가 끝난 상태, 홀수 초에는 설치한 상태
        second = 2;
        while (second != N + 1) {
            if (second % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombMap[i][j] == null) {
                            bombMap[i][j] = new Bomb(i, j, second);
                        }
                    }
                }
            } else {
                int bombTime = second - 3;
                Queue<Bomb> bombQueue = new ArrayDeque<>();
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombMap[i][j] != null && bombTime == bombMap[i][j].second) {
                            bombQueue.add(bombMap[i][j]);
                        }
                    }
                }
                while (!bombQueue.isEmpty()) {
                    Bomb bomb = bombQueue.poll();
                    for (int[] move : mover) {
                        int x = bomb.x + move[0];
                        int y = bomb.y + move[1];
                        if (x < 0 || y < 0 || x >= R || y >= C) {
                            continue;
                        }
                        bombMap[x][y] = null;
                    }
                }
            }
            second++;
        }

        StringBuilder sb = new StringBuilder();
        for (Bomb[] bombs : bombMap) {
            for (Bomb bomb : bombs) {
                if (bomb == null) {
                    sb.append(".");
                } else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Bomb extends Position {
        int second;

        Bomb(int x, int y, int second) {
            super(x, y);
            this.second = second;
        }
    }
}
