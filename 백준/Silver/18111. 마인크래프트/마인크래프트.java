import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = temp[0];
        int M = temp[1];
        int B = temp[2];

        int[] intMap = new int[257];
        for (int i = 0; i < N; i++) {
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(value -> intMap[value]++);
        }
        int minHeight = 0;
        int maxHeight = 256;
        for (int i = 0; i <= 256; i++)
            if (intMap[i] != 0) {
                minHeight = i;
                break;
            }
        for (int i = 256; i >= 0; i--)
            if (intMap[i] != 0) {
                maxHeight = i;
                break;
            }

        // 출력은 걸리는 시간과 땅의 높이
        // 땅의 높이는 256보다 작거나 같은 자연수 또는 0이다.
        int minTime = Integer.MAX_VALUE;
        int height = 0;

        if (minHeight == maxHeight) {
            bw.write("0 " + minHeight);
            bw.flush();
            return;
        }

        for (int i = maxHeight; i >= minHeight; i--) {  // 작성 시도 높이
            int[] map = intMap.clone();
            int sand = B; // 가용한 흙 양
            int time = 0;
            boolean flag = false;

            // 해당 높이로 만들면서 흙 생성
            for (int j = i + 1; j <= maxHeight; j++) {
                time += 2 * (map[j] * (j - i));
                sand += map[j] * (j - i);
                map[j] = 0;
            }

            for (int j = minHeight; j <= i; j++) {
                if (j == i) {
                    flag = true;
                    break;
                }
                int needed = map[j] * (i - j);
                if (sand < needed) break;
                sand -= needed;
                time += needed;
                map[j] = 0;
            }
            if (flag) {
                if (time < minTime) {
                    minTime = time;
                    height = i;
                }
            }
        }

        bw.write(minTime + " " + height);
        bw.flush();
    }
}
