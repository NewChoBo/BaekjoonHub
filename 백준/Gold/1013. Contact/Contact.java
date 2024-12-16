import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile("^(100+1+|01)+$");

		while (T-- > 0) {
			String input = br.readLine();
			Matcher matcher = pattern.matcher(input);
			// 정규식에 맞는지 확인
			if (matcher.matches()) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
