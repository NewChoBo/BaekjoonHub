import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			Map<String, Set<String>> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			while (n-- > 0) {
				String[] input = br.readLine().split(" ");    // 이름, 종류
				map.computeIfAbsent(input[1], k -> new HashSet<>()).add(input[0]);
			}
			int cnt = 1;
			for (Set<String> stringSet : map.values()) {
				cnt *= stringSet.size() + 1;
			}
			sb.append(cnt - 1).append('\n');
		}
		System.out.print(sb);
	}
}
