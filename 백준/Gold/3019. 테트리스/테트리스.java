import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int C = input1[0];
        int P = input1[1] - 1;
        int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][][] shapes = new int[][][]{{{0}, {0, 0, 0, 0}}, {{0, 0}}, {{0, 0, 1}, {0, -1}}, {{0, -1, -1}, {0, 1}}, {{0, 0, 0}, {0, 1}, {0, -1, 0}, {0, -1}}, {{0, 0, 0}, {0, -2}, {0, 1, 1}, {0, 0}}, {{0, 0, 0}, {0, 0}, {0, 0, -1}, {0, 2}}};
        int[][] shape = shapes[P];

        int cnt = 0;
        for (int i = 0; i < C; i++) {
            for (int[] line : shape) {
                boolean flag = true;
                for (int j = 0; j < line.length; j++) {
                    if (i + j >= C || map[i + j] != map[i] + line[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }
        }
        System.out.println(cnt);
    }
}