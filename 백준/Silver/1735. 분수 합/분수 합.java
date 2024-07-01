import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int a = input1[0] * input2[1] + input1[1] * input2[0];
        int b = input1[1] * input2[1];

        // 최대공약수 구하기
        int gcd = gcd(a, b);
        System.out.println(a / gcd + " " + b / gcd);
    }

    static int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            int n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
}