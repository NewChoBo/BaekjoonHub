import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input[0];
		int r = input[1];
		int c = input[2];

		// r행 c열을 언제 방문했는가?
		// N은 15보다 작다
		long no = 0;
		long mapSize = (long)Math.pow(2, N);
		for (int i = N; i >= 1; i--) {
			if (r >= mapSize / 2) {
				no += Math.pow(mapSize, 2) / 2;
				r -= mapSize / 2;
			}
			if (c >= mapSize / 2) {
				no += Math.pow(mapSize, 2) / 4;
				c -= mapSize / 2;
			}
			mapSize /= 2;
		}
		if (r == 1) {
			no += 2;
		}
		if (c == 1) {
			no += 1;
		}
		System.out.println(no);
	}
}
