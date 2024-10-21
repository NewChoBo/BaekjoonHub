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
		char[] chars = new char[1000001];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			map.put(input[1].charAt(0), input[0]);
		}
		String line = br.readLine();
		int index = 0;
		for (char c : line.toCharArray()) {
			String str = map.get(c);
			for (char c2 : str.toCharArray()) {
				chars[index] = c2;
				index++;
			}
		}
		int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();
		for (int i = input2[0] - 1; i < input2[1]; i++) {
			sb.append(chars[i]);
		}
		System.out.println(sb);
	}
}
