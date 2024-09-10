import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input[0];
		int M = input[1];

		Map<String, String> map = new HashMap<>();
		while (N-- > 0) {
			String[] line = br.readLine().split(" ");
			map.put(line[0], line[1]);
		}
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			String line = br.readLine();
			sb.append(map.get(line)).append("\n");
		}
		System.out.print(sb);
	}
}
