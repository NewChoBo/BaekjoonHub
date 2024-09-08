import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] charArr = str.toCharArray();
        BigInteger r = BigInteger.valueOf(31);
        BigInteger M = BigInteger.valueOf(1234567891);


        BigInteger sum = BigInteger.ZERO;
        BigInteger multiply = BigInteger.ONE;
        for (int i = 0; i < L; i++) {
            BigInteger num = BigInteger.valueOf(charArr[i] - 'a' + 1);
            sum = sum.add(num.multiply(multiply));
            multiply = multiply.multiply(r);
        }
        //출력할때는 1234567891을 나눠주자.
        System.out.println(sum.mod(M));
    }
}
