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
	static final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static final int[][] ways = new int[][] {{}, {0}, {0, 2}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3}};

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[][] map;
	static int wallCnt = 0;
	static int max = 0;
	/**
	 * CCTV 개수는 K개, 8개 이하
	 * CCTV 범위 유형은 1~5
	 *
	 * #: 0은 빈칸, 1~5는 CCTV 번호, 6은 벽
	 */
	static List<Cctv> cctvList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		init();

		// way 중 2번은 2가지 경우의 수 만 있고, 5번은 단일. 나머지는 4가지
		// 고정 감시구역 파악
		Set<Point> pointSet = new HashSet<>();
		if (!cctvList.isEmpty()) {
			dfs(pointSet, 0);
		}

		System.out.println((N * M) - (max + wallCnt));
		// System.out.println("N: " + N);
		// System.out.println("M: " + M);
		// System.out.println("max: " + max);
		// System.out.println("wallCnt:" + wallCnt);
	}

	static void dfs(Set<Point> set, int index) {
		if (index >= cctvList.size()) {
			if (max < set.size()) {
				// System.out.println(set);
				max = set.size();
			}
			return;
		}

		Cctv cctv = cctvList.get(index);
		int type = cctv.type;
		int[] way = ways[type];
		int rotateCnt = 4;    //회전 반영 필요. type이 5이거나 2면 회전 횟수 다름
		if (type == 5)
			rotateCnt = 1;
		if (type == 2)
			rotateCnt = 2;

		for (int i = 0; i < rotateCnt; i++) {
			Set<Point> tempSet = new HashSet<>(set);
			for (int dir : way) {
				int go = (dir + i) % 4;
				int[] goWay = directions[go];
				searchMap(cctv, tempSet, goWay);
			}
			dfs(tempSet, index + 1);
		}
	}

	static void searchMap(Point point, Set<Point> set, int[] direction) {
		int x = point.x;
		int y = point.y;

		while (x >= 0 && y >= 0 && x < N && y < M) {
			int num = map[x][y];
			if (num == 6) {
				return;
			}
			set.add(new Point(x, y));
			x += direction[0];
			y += direction[1];
		}
	}

	static void init() throws IOException {
		int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input1[0];
		M = input1[1];
		map = new int[N][];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int num = map[i][j];
				if (1 <= num && num <= 5) {
					cctvList.add(new Cctv(i, j, num));
				} else if (num == 6) {
					wallCnt++;
				}
			}
		}
	}

	static class Cctv extends Point {
		int type;

		Cctv(int x, int y, int type) {
			super(x, y);
			this.type = type;
		}
	}

	static class Point implements Comparable<Point> {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (o.x - this.x == 0 && o.y - this.y == 0)
				return 0;
			else
				return -1;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Point point = (Point)o;
			return x == point.x && y == point.y;
		}

		@Override
		public int hashCode() {
			return (this.x + "_" + this.y).hashCode();
		}

		public String toString() {
			return "(x: " + x + ", " + "y: " + y + ")";
		}
	}
}
