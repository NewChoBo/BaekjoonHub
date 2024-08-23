import java.io.*;
import java.math.BigInteger;

public class Main {
    // https://www.acmicpc.net/problem/30802

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int input = Integer.parseInt(br.readLine());
        BigInteger number = BigInteger.ONE;
        for (int i = input; i > 0; i--) {
            number = number.multiply(BigInteger.valueOf(i));
        }
        String num = number.toString().trim();
        char[] chars = num.toCharArray();
        int cnt = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] == '0') cnt++;
            else break;
        }
        System.out.println(cnt);
    }
}