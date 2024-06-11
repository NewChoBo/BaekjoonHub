import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		while (true) {
			String input = br.readLine();
			if (input.equals("-1")) {
				break;
			}
			int n = Integer.parseInt(input);
			int sum = 0;
			Queue<Integer> integerArrayList = new ArrayDeque<>();

			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					integerArrayList.add(i);
					sum += i;
				}
			}

			bw.write(n + " ");
			if (sum == n) {
				bw.write("=");
				while (true) {
					bw.write(" " + integerArrayList.poll());
					if (!integerArrayList.isEmpty()) {
						bw.write(" +");
					} else {
						break;
					}
				}
			} else {
				bw.write("is NOT perfect.");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
