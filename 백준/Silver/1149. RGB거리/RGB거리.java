import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // N개의 집이 있음
        // 거리는 선분으로
        // 집은 빨, 초, 파 중 하나로 칠해짐
        // 각 집 빨, 초, 파 로 칠할 때, 아래 규칙 만족하며 모든 집 칠하는 최솟값은?
        // 1. 1번과 2번은 서로 다른 색
        // 2. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다
        // 3. i번 집은 전/후 집과 색상이 달라야 한다
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][];
        int[][] sum = new int[N][];
        for (int i = 0; i < N; i++) {
            info[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sum[i] = new int[3];
        }

        // 현재 위치의 색상을 무조건 동일한걸로 한다고 가정
        sum[0] = info[0].clone();
        for (int i = 1; i < N; i++) {
            int[] prevSum = sum[i - 1];
            for (int j = 0; j < 3; j++) {
                int min = getMin(prevSum, j);
                sum[i][j] = min + info[i][j];
            }
        }

        OptionalInt optionalInt = Arrays.stream(sum[N - 1]).min();
        int result = optionalInt.isPresent() ? optionalInt.getAsInt() : Integer.MAX_VALUE;
        System.out.println(result);
    }

    static int getMin(int[] prevSum, int index) {
        switch (index) {
            case 0:
                return Math.min(prevSum[1], prevSum[2]);
            case 1:
                return Math.min(prevSum[0], prevSum[2]);
            case 2:
                return Math.min(prevSum[0], prevSum[1]);
        }
        return Integer.MAX_VALUE;
    }
}
