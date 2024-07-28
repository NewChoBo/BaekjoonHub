import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int R, C, T;
	static int[][] map;

	static int cleaner;
	static int[][] mover = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		/**
		 * 절차
		 * 1초간 동작 과정
		 * 1. 미세먼지 확산(확산은 미세먼지가 있는 모든 칸에서 발생)
		 * 	- (r, c)의 미세먼지는 인접한 네 방향으로 확산
		 * 	- 칸이 없거나 공기청정기 위치로는 확산이 일어나지 않음
		 * 	- 확산되는 양은 현재 위치의 미세먼지 /5
		 * 	- 남은 미세먼지의 양은 확산된 만큼 마이너스
		 * 2. 공기청정기 작동
		 * 	- 공기청정기가 바람
		 * 	- 위쪽은 반시계방향 순환, 아래쪽은 시계방향 순환
		 * 	- 바람 불면 미세먼지 바람 방향으로 이동
		 * 	- 공기청정기에서 부는 바람은 미세먼지 없음
		 * 	- 공기청정기로 들어간 미세먼지는 정화됨
		 */
		init();
		while (T-- > 0) {
			int[][] newMap = createMap();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					spreadMap(i, j, newMap);
				}
			}
			map = newMap;
			moveAirs();
		}

		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cnt += map[i][j];
			}
		}
		System.out.println(cnt);
	}

	static void cleanAir() {
		map[cleaner][0] = 0;
		map[cleaner + 1][0] = 0;
	}

	static void moveAirs() {
		// 1. y=0 열 공기 이동
		for (int i = cleaner; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int i = cleaner + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		cleanAir();

		// 2. 최상단 / 최하단 공기 이동
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
			map[R - 1][i] = map[R - 1][i + 1];
		}

		// 3. 가장 우측 (C - 1)열 공기 이동
		for (int i = 0; i < cleaner; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = R - 1; i > cleaner + 1; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}

		for (int i = C - 1; i > 0; i--) {
			map[cleaner][i] = map[cleaner][i - 1];
			map[cleaner + 1][i] = map[cleaner + 1][i - 1];
		}
	}

	static int[][] createMap() {
		int[][] map = new int[R][];
		for (int i = 0; i < R; i++) {
			map[i] = new int[C];
		}
		return map;
	}

	static void spreadMap(int x, int y, int[][] newMap) {
		int spread = 0;
		int num = map[x][y];
		int val = num / 5;

		for (int[] move : mover) {
			int newX = x + move[0];
			int newY = y + move[1];

			if (!isValid(newX, newY))
				continue;
			spread++;
			newMap[newX][newY] += val;
		}
		newMap[x][y] += map[x][y] - (val * spread);
	}

	static boolean isValid(int x, int y) {
		return (x >= 0 && x < R && y >= 0 && y < C)
			&& ((x != cleaner && x != cleaner + 1) || y != 0);
	}

	static void init() throws IOException {
		// T초가 지난 후 구사과 방에 남아있는 미세먼지의 양 출력
		int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		R = input1[0];
		C = input1[1];
		T = input1[2];
		map = new int[R][];
		for (int i = 0; i < R; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				cleaner = i;
				return;
			}
		}
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(x: " + x + ", " + "y: " + y + ")";
		}
	}
}
