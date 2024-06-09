import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[2];
		int[] y = new int[2];

		x[0] = Integer.MAX_VALUE;
		x[1] = Integer.MIN_VALUE;
		y[0] = Integer.MAX_VALUE;
		y[1] = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			if (x[0] > input[0]) {
				x[0] = input[0];
			}
			if (x[1] < input[0]) {
				x[1] = input[0];
			}
			if (y[0] > input[1]) {
				y[0] = input[1];
			}
			if (y[1] < input[1]) {
				y[1] = input[1];
			}
		}
		bw.write(String.valueOf((x[1] - x[0]) * (y[1] - y[0])));
		bw.flush();
	}
}
