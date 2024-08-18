import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int A = input[0];
		int B = input[1];
		int C = input[2];

		BigInteger bigInteger = BigInteger.valueOf(A);
		bigInteger = bigInteger.modPow(BigInteger.valueOf(B), BigInteger.valueOf(C));
		System.out.println(bigInteger.intValue());
	}
}
