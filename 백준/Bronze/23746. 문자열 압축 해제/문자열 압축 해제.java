import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		String[] items = new String['Z' - 'A' + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			char c = st.nextToken().charAt(0);
			items[c - 'A'] = str;
		}
		String line = br.readLine();
		for (char c : line.toCharArray()) {
			String str = items[c - 'A'];
			sb.append(str);
		}
		int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(sb.substring(input2[0] - 1, input2[1]));
	}
}
