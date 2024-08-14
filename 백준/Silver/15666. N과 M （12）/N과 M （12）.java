import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] line;
	static Set<String> stringSet = new HashSet<>();

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		M = input[1];
		line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(line);

		// 1부터 N까지 수 중에서 중복 없이 M개를 고른 수열
		// 고른 수열은 오름차순
		// ==> 백트래킹
		for (int i = 0; i < N; i++) {
			createArr(new ArrayList<>(), i);
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static void createArr(List<Integer> list, int current) {
		list.add(current);
		if (list.size() >= M) {
			StringBuilder sb2 = new StringBuilder();
			for (int num : list) {
				sb2.append(line[num]).append(' ');
			}
			if (!stringSet.contains(sb2.toString())) {
				stringSet.add(sb2.toString());
				sb.append(sb2).append('\n');
			}
		} else {
			for (int i = current; i < N; i++) {
				createArr(list, i);
			}
		}
		list.remove(list.size() - 1);
	}
}
