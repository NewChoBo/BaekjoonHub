import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int L = 'L' - 'A' + 1;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N < L || M < 4) {
                sb.append(-1).append('\n');
            } else {
                sb.append((L-1) * M + 4).append('\n');
            }
        }
        System.out.println(sb);
    }

    static class Point {
        int time = Integer.MAX_VALUE;
        Map<Integer, Integer> canGo = new HashMap<>();
    }
}
