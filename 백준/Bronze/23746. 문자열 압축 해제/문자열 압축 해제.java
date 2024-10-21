import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Map<Character, String> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			map.put(input[1].charAt(0), input[0]);
		}
		String line = br.readLine();
		for (char c : line.toCharArray()) {
			String str = map.get(c);
			sb.append(str);
		}
		int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(sb.substring(input2[0] - 1, input2[1]));
	}
}
