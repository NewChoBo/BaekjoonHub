import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input[0];
		int D = input[1];

		// 초기화
		int[] road = new int[D + 1];
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		for (int i = 0; i < D + 1; i++)
			road[i] = i;
		for (int i = 0; i < N; i++) {
			queue.offer(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
		}

		while (!queue.isEmpty()) {
			int[] shortCut = queue.poll();    // 출발지, 도착지, 거리
			int start = shortCut[0];
			int end = shortCut[1];
			if (start > D || end > D)
				continue;
			int distance = shortCut[2];
			if (road[start] + distance < road[end]) {
				road[end] = road[start] + distance;
				while (end < D) {
					if (road[end] >= road[end + 1])
						break;
					road[end + 1] = road[end] + 1;
					end++;
				}
			}
		}
		bw.write(String.valueOf(road[D]));
		bw.flush();
	}
}
