import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = temp[0];
        int M = temp[1];

        int[][] arr = new int[N][];
        for (int a = 0; a < N; a++) {
            arr[a] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int K = Integer.parseInt(br.readLine());
        for (int a = 0; a < K; a++) {
            int[] tempPosition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] position1 = new int[]{tempPosition[0], tempPosition[1]};
            int[] position2 = new int[]{tempPosition[2], tempPosition[3]};

            int sum = 0;
            for (int i = position1[0] - 1; i < position2[0]; i++) {
                for (int j = position1[1] - 1; j < position2[1]; j++) {
                    sum += arr[i][j];
                }
            }

            bw.write(sum + "\n");
        }

        bw.flush();
    }
}