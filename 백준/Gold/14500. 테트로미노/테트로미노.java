import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static List<int[][]> tetrominos;

    public static void main(String[] args) throws IOException {
        tetrominos = getTetromino();
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input1[0];
        M = input1[1];
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                new Point(i, j).updateMax();
            }
        }

        System.out.println(max);
    }

    static List<int[][]> getTetromino() {
        List<int[][]> list = new ArrayList<>();
        int[][][] basicShapes = {{{0, 0}, {0, 1}, {0, 2}, {0, 3}},  // I
                {{0, 0}, {0, 1}, {1, 0}, {1, 1}},  // O
                {{0, 0}, {1, 0}, {2, 0}, {2, 1}},  // L
                {{0, 0}, {1, 0}, {1, 1}, {2, 1}},  // S
                {{0, 0}, {0, 1}, {0, 2}, {1, 1}}   // T
        };

        for (int[][] shape : basicShapes) {
            list.addAll(getAllRotations(shape));
        }

        return list;
    }

    static List<int[][]> getAllRotations(int[][] shape) {
        List<int[][]> rotations = new ArrayList<>();
        rotations.add(shape);
        for (int i = 1; i < 4; i++) {
            shape = rotate(shape);
            rotations.add(shape);
        }
        List<int[][]> mirrored = new ArrayList<>();
        for (int[][] s : rotations) {
            mirrored.add(mirror(s));
        }
        rotations.addAll(mirrored);
        return rotations;
    }

    static int[][] rotate(int[][] shape) {
        int[][] newShape = new int[4][2];
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            newShape[i][0] = -shape[i][1];
            newShape[i][1] = shape[i][0];
            minX = Math.min(minX, newShape[i][0]);
            minY = Math.min(minY, newShape[i][1]);
        }

        // 0,0 기준으로 이동
        for (int i = 0; i < 4; i++) {
            newShape[i][0] -= minX;
            newShape[i][1] -= minY;
        }

        return newShape;
    }

    static int[][] mirror(int[][] shape) {
        int[][] newShape = new int[4][2];
        int minY = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            newShape[i][0] = shape[i][0];
            newShape[i][1] = -shape[i][1];
            minY = Math.min(minY, newShape[i][1]);
        }

        // 0,0 기준으로 이동
        for (int i = 0; i < 4; i++) {
            newShape[i][1] -= minY;
        }

        return newShape;
    }

    static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static boolean valid(int x, int y, int[] point) {
        return valid(x + point[0], y + point[1]);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void updateMax() {
            for (int[][] shape : tetrominos) {
                boolean flag = true;
                for (int[] newPosition : shape) {
                    if (!valid(x + newPosition[0], y + newPosition[1])) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) continue;

                int sum = 0;
                for (int[] newPosition : shape) {
                    sum += map[x + newPosition[0]][y + newPosition[1]];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
    }
}
