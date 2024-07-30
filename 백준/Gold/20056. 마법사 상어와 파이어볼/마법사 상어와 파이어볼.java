import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	static final int[][] mover = new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static final int[] moveA = new int[] {0, 2, 4, 6};
	static final int[] moveB = new int[] {1, 3, 5, 7};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input1[0];
		int M = input1[1];
		int K = input1[2];      //K번 명령

		HashMap<Integer, Map<Integer, FireballContainer>> map = getNewContainer();
		for (int i = 0; i < M; i++) {
			// r:행, c:열, m:질량, d:방향, s:속력
			Fireball fireball = new Fireball(br.readLine());
			addFireball(fireball, map);
		}
		// System.out.println("초기");
		// map.forEach((keyR, value) -> value.forEach((keyC, fireballContainer) -> fireballContainer.fireballList.forEach(
		// 	fireball -> System.out.println(fireball))));

		//모든 파이어볼이 자신의 방향/속력만큼 이동, K번
		for (int i = 0; i < K; i++) {
			// System.out.println(i + "번째 순회");
			HashMap<Integer, Map<Integer, FireballContainer>> newContainer = getNewContainer();

			// 현재 모든 컨테이너에 대해 수행
			map.forEach((keyR, value) -> value.forEach((keyC, fireballContainer) -> {
				List<Fireball> fireballList = fireballContainer.fireballList;
				for (Fireball fireball : fireballList) {    // 모든 파이어볼 이동
					int[] move = mover[fireball.d];
					int x = keyR + (move[0] * fireball.s);
					int y = keyC + (move[1] * fireball.s);
					// 1번 열은 N번 열과 연결되어 있다.
					x = (x % N + N) % N;
					y = (y % N + N) % N;
					fireball.r = x;
					fireball.c = y;
					addFireball(fireball, newContainer);
				}
			}));

			// 파이어볼 산개 준비
			newContainer.forEach((keyR, value) -> {
				List<Integer> keyList = value.keySet().stream().collect(Collectors.toList());
				keyList.forEach(keyC -> {
					FireballContainer fireballContainer = value.get(keyC);
					List<Fireball> fireballList = fireballContainer.fireballList;
					if (fireballList.size() == 1) {
						return;
					}
					int m = 0;
					int divCnt = 0;
					int s = 0;

					for (Fireball fireball : fireballList) {
						m += fireball.m;
						s += fireball.s;
						if (fireball.d % 2 == 0)
							divCnt++;
					}

					// System.out.println(m);
					m /= 5;
					if (m == 0) {
						value.remove(keyC);
						return;
					}

					s /= fireballList.size();
					fireballContainer.fireballList = new ArrayList<>();
					int[] way = (divCnt == 0 || divCnt == fireballList.size()) ? moveA : moveB;
					for (int d : way) {
						fireballContainer.fireballList.add(new Fireball(keyR, keyC, m, s, d));
					}
				});
			});

			map = newContainer;
			// map.forEach((keyR, value) -> value.forEach(
			// 	(keyC, fireballContainer) -> fireballContainer.fireballList.forEach(
			// 		fireball -> System.out.println(fireball))));
		}
		map.forEach((keyR, value) -> value.forEach(
			(keyC, fireballContainer) -> fireballContainer.fireballList.forEach(fireball -> sum += fireball.m)));
		System.out.println(sum);
	}

	static void addFireball(Fireball fireball, Map<Integer, Map<Integer, FireballContainer>> containerR) {
		containerR.computeIfAbsent(fireball.r, k -> new HashMap<>())
			.computeIfAbsent(fireball.c, k -> new FireballContainer()).fireballList.add(fireball);
	}

	static HashMap<Integer, Map<Integer, FireballContainer>> getNewContainer() {
		return new HashMap<>();
	}

	static class FireballContainer {
		List<Fireball> fireballList = new ArrayList<>();
	}

	static class Fireball {
		int r, c, m, s, d;

		// ri, ci, mi, si, di
		// x, y, 질량, 속력, 방향
		Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		Fireball(String input) {
			this(Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray());
		}

		Fireball(int[] input) {
			this(input[0], input[1], input[2], input[3], input[4]);
		}

		@Override
		public String toString() {
			return "r: " + r + ", c: " + c + ", m: " + m + ", s: " + s + ", d: " + d;
		}
	}
}
