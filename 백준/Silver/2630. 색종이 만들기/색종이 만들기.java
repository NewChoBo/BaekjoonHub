import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] cnt = new int[2];

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// 흰색은 0, 파랑은 1. 흰색 다음 파란색 출력
		// 재귀함수 활용?
		recursive(map, new Point(0, 0), new Point(N, N));
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}

	static void recursive(int[][] map, Point start, Point end) {
		// System.out.println("start: " + start + ", end: " + end);
		int color = map[start.x][start.y];
		boolean flag = true;
		for (int i = start.x; i < end.x; i++) {
			if (!flag) {
				break;
			}
			for (int j = start.y; j < end.y; j++) {
				if (map[i][j] != color) {
					flag = false;
					break;
				}
			}
		}

		if (!flag) {
			// 중간지점 구하기
			int diff = (end.x - start.x) / 2;
			int midX = start.x + diff;
			int midY = start.y + diff;

			recursive(map, start, new Point(midX, midY));
			recursive(map, new Point(midX, start.y), new Point(end.x, midY));
			recursive(map, new Point(start.x, midY), new Point(midX, end.y));
			recursive(map, new Point(midX, midY), end);
		} else {
			cnt[color]++;
		}
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "{ x: " + x + ", y: " + y + " }";
		}
	}
}
