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

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		M = input[1];
		line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		line = Arrays.stream(line).sorted().toArray();

		// 1부터 N까지 수 중에서 중복 없이 M개를 고른 수열
		// 고른 수열은 오름차순
		// ==> 백트래킹
		for (int i = 0; i < N; i++) {
			createArr(new ArrayList<>(), i, new HashSet<>());
		}
		System.out.print(sb);
	}

	static void createArr(List<Integer> list, int current, Set<Integer> visited) {
		visited.add(current);
		list.add(current);
		if (list.size() >= M) {
			for (int num : list) {
				sb.append(line[num]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited.contains(i)) {
				createArr(list, i, visited);
				visited.remove(i);
				list.remove(list.size() - 1);
			}
		}
	}
}
