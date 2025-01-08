import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        dp[0][0][0] = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
                .append(w(a, b, c)).append('\n');
        }
        System.out.print(sb);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        int d = a < 0 ? (a * -1) + 50 : a;
        int e = b < 0 ? (b * -1) + 50 : b;
        int f = c < 0 ? (c * -1) + 50 : c;
        if (dp[d][e][f] != 0) {
            return dp[d][e][f];
        }
        if (a > 20 || b > 20 || c > 20) {
            dp[d][e][f] = w(20, 20, 20);
            return dp[d][e][f];
        }
        if (a < b && b < c) {
            int result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            dp[d][e][f] = result;
            return dp[d][e][f];
        }
        int result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        dp[d][e][f] = result;
        return dp[d][e][f];
    }
}
