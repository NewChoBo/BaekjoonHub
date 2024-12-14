import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N, Q;
	static Point[] points;

	public static void main(String[] args) {
		try {
			init();
			solve();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void solve() {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		try {
			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				Set<Integer> visited = new HashSet<>();
				Queue<Integer> queue = new ArrayDeque<>();
				visited.add(v);
				queue.add(v);
				while (!queue.isEmpty()) {
					int current = queue.poll();
					for (Map.Entry<Integer, Integer> entry : points[current].link.entrySet()) {
						if (entry.getValue() < k || visited.contains(entry.getKey()))
							continue;
						queue.add(entry.getKey());
						visited.add(entry.getKey());
					}
				}
				sb.append(visited.size() - 1).append('\n');
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.print(sb);
	}

	private static void init() {
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			points = new Point[N + 1];

			for (int i = 0; i <= N; i++) {
				points[i] = new Point();
			}

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int q = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				points[p].link.put(q, r);
				points[q].link.put(p, r);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	static class Point {
		Map<Integer, Integer> link = new HashMap<>();
	}
}