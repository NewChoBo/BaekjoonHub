import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(getTimeToMeltCheese());
	}

	static int getTimeToMeltCheese() {
		int time = 0;

		while (true) {
			visited = new boolean[N][M];
			Queue<int[]> airQueue = new LinkedList<>();
			airQueue.add(new int[] {0, 0});
			visited[0][0] = true;

			// BFS로 외부 공기를 찾음
			while (!airQueue.isEmpty()) {
				int[] current = airQueue.poll();
				int x = current[0];
				int y = current[1];

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] != 1) {
						visited[nx][ny] = true;
						airQueue.add(new int[] {nx, ny});
					}
				}
			}

			boolean hasCheese = false;
			List<int[]> meltingCheese = new ArrayList<>();

			// 치즈가 두 변 이상 외부 공기와 접촉한지 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						hasCheese = true;
						int contact = 0;

						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];

							if (visited[nx][ny]) {
								contact++;
							}
						}

						if (contact >= 2) {
							meltingCheese.add(new int[] {i, j});
						}
					}
				}
			}

			// 치즈가 다 녹았다면 종료
			if (!hasCheese) {
				break;
			}

			// 녹은 치즈를 외부 공기로 변경
			for (int[] cheese : meltingCheese) {
				map[cheese[0]][cheese[1]] = 0;
			}

			time++;
		}

		return time;
	}
}
