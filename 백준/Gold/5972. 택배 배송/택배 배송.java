import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input1[0];
		int M = input1[1];
		Point[] map = new Point[N + 1];
		for (int i = 0; i < map.length; i++) {
			map[i] = new Point();
		}

		//현서는 헛간 1, 찬홍이는 헛간 N
		for (int i = 0; i < M; i++) {
			input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int A, B, C;
			A = input1[0];
			B = input1[1];
			C = input1[2];

			if (map[A].way.get(B) == null || map[A].way.get(B) > C) {
				map[A].way.put(B, C);
				map[B].way.put(A, C);
			}
		}

		Queue<Point> position = new PriorityQueue<>(Comparator.comparing(p -> p.weight));
		map[1].weight = 0;
		position.add(map[1]);
		while (!position.isEmpty()) {
			Point currentPoint = position.poll();
			int currentWeight = currentPoint.weight;
			currentPoint.visited = false;
			for (Map.Entry<Integer, Integer> entry : currentPoint.way.entrySet()) {
				int key = entry.getKey();
				int value = currentWeight + entry.getValue();
				if (value >= map[N].weight)
					continue;
				if (map[key].weight > value) {
					map[key].weight = value;
				} else {
					continue;
				}
				if (key != N && !map[key].visited) {
					position.add(map[key]);
					map[key].visited = true;
				}
			}
		}
		System.out.println(map[N].weight);
	}

	static class Point {
		int weight = Integer.MAX_VALUE;
		boolean visited = false;
		Map<Integer, Integer> way = new HashMap<>();
	}
}
