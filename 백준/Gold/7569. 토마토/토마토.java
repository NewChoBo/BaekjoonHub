import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	private static final int[][] mover = new int[][] {{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1},
		{0, 0, -1}};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int M, N, H;
	private static int[][][] map;

	// 2: 익을 토마토
	// 1: 익은 토마토
	// 0: 안익은 토마토
	// -1: 토마토 없음

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int M = input[0];
		int N = input[1];
		int H = input[2];
		map = new int[H][][];
		for (int i = 0; i < H; i++) {
			map[i] = new int[N][];
			for (int j = 0; j < N; j++) {
				map[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
		}

		// 익은 토마토 큐에 삽입
		Queue<int[]> ripeTomato = new ArrayDeque<>();
		for (int h = 0; h < H; h++) {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (map[h][x][y] == 1)
						ripeTomato.add(new int[] {h, x, y});
				}
			}
		}

		int cnt = -1;
		while (!ripeTomato.isEmpty()) {
			Queue<int[]> saveQueue = new ArrayDeque<>();
			cnt++;

			while (!ripeTomato.isEmpty()) {
				int[] currentTomato = ripeTomato.poll();
				int h = currentTomato[0];
				int x = currentTomato[1];
				int y = currentTomato[2];
				map[h][x][y] = 1;

				for (int[] move : mover) {
					int tH = h + move[0];
					int tX = x + move[1];
					int tY = y + move[2];
					if (isValid(map, tH, tX, tY)) {
						map[tH][tX][tY] = 2;
						saveQueue.add(new int[] {tH, tX, tY});
					}
				}
			}
			ripeTomato.addAll(saveQueue);
		}

		for (int[][] floor : map) {
			for (int[] line : floor) {
				for (int num : line) {
					if (num == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(cnt);
	}

	public static boolean isValid(int[][][] map, int h, int x, int y) {
		try {
			return map[h][x][y] == 0;
		} catch (Exception e) {
			return false;
		}
	}
}
