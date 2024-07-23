import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[1001];
        map[0] = 1;
        map[1] = 1;

        for (int i = 2; i <= n; i++) {
            map[i] = (map[i - 2]*2 + map[i - 1]) % 10007;
        }
        System.out.println(map[n]);
    }
}