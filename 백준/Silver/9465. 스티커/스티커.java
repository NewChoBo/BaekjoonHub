import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[2][];
			int[][] dpMap = new int[2][];
			map[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			map[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			dpMap[0] = map[0].clone();
			dpMap[1] = map[1].clone();
			for (int i = 0; i < n; i++) {
				// 현 위치를 뽑는다고 가정할 때 최대값 확인
				if (i - 2 >= 0) {
					if (dpMap[0][i] < dpMap[1][i - 2] + map[0][i]) {
						dpMap[0][i] = dpMap[1][i - 2] + map[0][i];
					}
					if (dpMap[1][i] < dpMap[0][i - 2] + map[1][i]) {
						dpMap[1][i] = dpMap[0][i - 2] + map[1][i];
					}
				}
				if (i - 1 >= 0) {
					if (dpMap[0][i] < dpMap[1][i - 1] + map[0][i]) {
						dpMap[0][i] = dpMap[1][i - 1] + map[0][i];
					}
					if (dpMap[1][i] < dpMap[0][i - 1] + map[1][i]) {
						dpMap[1][i] = dpMap[0][i - 1] + map[1][i];
					}
				}
			}
			int max = Integer.max(dpMap[0][n - 1], dpMap[1][n - 1]);
			sb.append(max).append('\n');
		}
		System.out.print(sb);
	}
}
