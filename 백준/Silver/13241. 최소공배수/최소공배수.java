import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long a = input[0];
        long b = input[1];

        if (a == b) {
            System.out.println(a);
            return;
        }
        if (b > a) {    // a가 더 큰 수가 되도록 swap
            long temp = a;
            a = b;
            b = temp;
        }

        long gcd = gcd(a, b);
        long lcm = (a * b) / gcd;

        System.out.println(lcm);
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
