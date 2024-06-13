import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = temp[0];
		int K = temp[1];
		int result = 0;

		boolean[] arr = new boolean[N + 1];
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (!arr[i]) {
				int j = 1;
				while (i * j <= N) {
					if (!arr[i * j]) {
						cnt++;
						arr[i * j] = true;
						if (cnt == K) {
							result = i * j;
							break;
						}
					}
					j++;
				}
			}
			if (result != 0) {
				break;
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
