import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// A, B를 입력받고 E의 최솟값 출력
		// A보다 크고, 또한 B를 첫 숫자로 갖는. 답 없으면 0
		// Bessie가 올바른 답을 하도록 도와라
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int A = input[0];
		int B = input[1];

		int answer = 0;
		BigInteger bigInteger = BigInteger.ONE;
		for (int i = 0; i < A; i++) {
			bigInteger = bigInteger.multiply(BigInteger.valueOf(2));
		}
		for (int i = A + 1; i <= 62; i++) {
			bigInteger = bigInteger.multiply(BigInteger.valueOf(2));
			if (bigInteger.toString().charAt(0) - '0' == B) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
