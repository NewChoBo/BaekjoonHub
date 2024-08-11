import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			// D, I, n
			// D 1: 최댓값 삭제, D -1: 최솟값 삭제
			// I n은 n 삽입
			int k = Integer.parseInt(br.readLine());    // Q에 적용될 연산의 개수
			TreeMap<Integer, Integer> counter = new TreeMap<>();

			for (int i = 0; i < k; i++) {
				String input = br.readLine();
				char c = input.charAt(0);
				int num = Integer.parseInt(input.split(" ")[1]);

				switch (c) {
					case 'I':
						counter.put(num, counter.computeIfAbsent(num, key -> 0) + 1);
						break;
					case 'D':
						Map.Entry<Integer, Integer> currentEntry;
						if (num == 1) {
							currentEntry = counter.lastEntry();
						} else {
							currentEntry = counter.firstEntry();
						}
						if (currentEntry != null) {
							int newValue = currentEntry.getValue() - 1;
							if (newValue <= 0) {
								counter.remove(currentEntry.getKey());
							} else {
								counter.put(currentEntry.getKey(), newValue);
							}
						}
						break;
				}
			}

			Map.Entry<Integer, Integer> maxEntry = counter.lastEntry();
			if (maxEntry != null) {
				Map.Entry<Integer, Integer> minEntry = counter.firstEntry();
				sb.append(maxEntry.getKey()).append(' ').append(minEntry.getKey());
			} else {
				sb.append("EMPTY");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
