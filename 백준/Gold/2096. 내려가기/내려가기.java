import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][];
        int[][] maxCounter = new int[N][3];
        int[][] minCounter = new int[N][3];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        maxCounter[0] = map[0];
        minCounter[0] = map[0];

        // 첫째 줄에 얻을 수 있는 최대 / 최소 수
        // 아래, 대각선으로 이동
        for (int i = 1; i < N; i++) {
            maxCounter[i][0] = Math.max(maxCounter[i - 1][0], maxCounter[i - 1][1]) + map[i][0];
            maxCounter[i][1] = Math.max(Math.max(maxCounter[i - 1][0], maxCounter[i - 1][1]), maxCounter[i - 1][2]) + map[i][1];
            maxCounter[i][2] = Math.max(maxCounter[i - 1][2], maxCounter[i - 1][1]) + map[i][2];

            minCounter[i][0] = Math.min(minCounter[i - 1][0], minCounter[i - 1][1]) + map[i][0];
            minCounter[i][1] = Math.min(Math.min(minCounter[i - 1][0], minCounter[i - 1][1]), minCounter[i - 1][2]) + map[i][1];
            minCounter[i][2] = Math.min(minCounter[i - 1][2], minCounter[i - 1][1]) + map[i][2];
        }

        int max = Math.max(Math.max(maxCounter[N - 1][0], maxCounter[N - 1][1]), maxCounter[N - 1][2]);
        int min = Math.min(Math.min(minCounter[N - 1][0], minCounter[N - 1][1]), minCounter[N - 1][2]);
        System.out.println(max + " " + min);
    }
}