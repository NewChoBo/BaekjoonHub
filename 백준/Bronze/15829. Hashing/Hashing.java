import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int r = 31;
        int M = 1234567891;
        BigInteger sum = BigInteger.ZERO;
        BigInteger bigR = BigInteger.valueOf(r);
        BigInteger bigM = BigInteger.valueOf(M);
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            BigInteger index = BigInteger.valueOf(i);
            char c = charArr[i];
            BigInteger num = BigInteger.valueOf(c - 'a' + 1);
            BigInteger bigInteger = bigR.modPow(index, bigM);
            sum = sum.add(num.multiply(bigInteger));
        }
        System.out.println(sum);

        // 해시 함수. a=1, b=2...
        // 문자열 혹은 하나의 정수로 치환
        // 수열의 값
    }
}
