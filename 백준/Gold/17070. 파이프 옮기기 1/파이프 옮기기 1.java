import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[][] map;

	static long[][][] countMap;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][];
		countMap = new long[N][][];

		// 모든 map 초기화
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			countMap[i] = new long[N][];
			for (int j = 0; j < N; j++) {
				countMap[i][j] = new long[3];
			}
		}

		countMap[0][1][0] = 1;

		// 맨 위, 왼쪽부터 오른쪽으로 이동하며 순회
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!valid(i, j))
					continue;

				boolean valid0 = valid(i, j - 1);
				boolean valid1 = valid(i - 1, j - 1);
				boolean valid2 = valid(i - 1, j);

				if (valid0 && j - 1 >= 0) {
					countMap[i][j][0] += countMap[i][j - 1][0] + countMap[i][j - 1][1];
				}
				if (valid0 && valid1 && valid2 && j - 1 >= 0 && i - 1 >= 0) {
					countMap[i][j][1] +=
						countMap[i - 1][j - 1][0] + countMap[i - 1][j - 1][1] + countMap[i - 1][j - 1][2];
				}
				if (valid2 && i - 1 >= 0) {
					countMap[i][j][2] += countMap[i - 1][j][2] + countMap[i - 1][j][1];
				}
			}
		}

		long[] last = countMap[N - 1][N - 1];
		System.out.println(last[0] + last[1] + last[2]);
	}

	static boolean valid(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N && map[x][y] != 1;
	}
}
