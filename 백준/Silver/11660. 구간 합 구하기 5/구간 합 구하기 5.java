import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sumMap = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < N + 1; j++) {
                sumMap[i][j] = array[j - 1] + sumMap[i - 1][j] + sumMap[i][j - 1] - sumMap[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = sumMap[x2][y2] - (sumMap[x1 - 1][y2] + sumMap[x2][y1 - 1]) + sumMap[x1 - 1][y1 - 1];
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}