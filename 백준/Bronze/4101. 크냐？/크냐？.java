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
		while (true) {
			String input = br.readLine();
			if ("0 0".equals(input))
				break;

			int[] input1 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			if (input1[0] > input1[1])
				bw.write("Yes\n");
			else
				bw.write("No\n");
		}
		bw.flush();
	}
}
