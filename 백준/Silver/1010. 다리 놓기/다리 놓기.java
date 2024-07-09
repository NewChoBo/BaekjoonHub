import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = input[1];
            int M = input[0];

            BigInteger answer = BigInteger.ONE;
            for (int i = (N - M) + 1; i <= N; i++) {
                answer = answer.multiply(BigInteger.valueOf(i));
            }
            for (int i = M; i > 0; i--) {
                answer = answer.divide(BigInteger.valueOf(i));
            }
            System.out.println(answer);
        }
    }
}