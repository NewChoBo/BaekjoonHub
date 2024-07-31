import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/20056
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i < T + 1; i++) {
            int N = Integer.parseInt(br.readLine());    // 선의 위치
            List<int[]> lines = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                lines.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            lines.sort((o1, o2) -> {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            });

            int cnt = 0;
            for (int j = 0; j < lines.size(); j++) {
                int heightB = lines.get(j)[1];
                for (int k = j; k < lines.size(); k++) {
                    int heightB2 = lines.get(k)[1];
                    if (heightB > heightB2) {
                        cnt++;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + cnt);
        }
    }
}