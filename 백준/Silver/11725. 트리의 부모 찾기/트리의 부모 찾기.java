import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Node> map = new HashMap<>();
		for (int i = 1; i < N; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if (!map.containsKey(input[0])) {
				map.put(input[0], new Node(input[0]));
			}
			map.get(input[0]).integerSet.add(input[1]);
			if (!map.containsKey(input[1])) {
				map.put(input[1], new Node(input[1]));
			}
			map.get(input[1]).integerSet.add(input[0]);
		}
		Queue<Node> queue = new ArrayDeque<>();
		map.get(1).visited = true;
		queue.add(map.get(1));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int num : node.integerSet) {
				Node current = map.get(num);
				if (current.visited)
					continue;
				current.visited = true;
				current.parent = node.value;
				queue.add(current);
			}
		}
		List<Integer> keyList = map.keySet().stream().sorted().collect(Collectors.toList());
		StringBuilder sb = new StringBuilder();
		for (int num : keyList) {
			if (num == 1)
				continue;
			sb.append(map.get(num).parent).append('\n');
		}
		System.out.print(sb);
	}

	static class Node {
		Integer parent;
		int value;
		Set<Integer> integerSet = new HashSet<>();
		boolean visited = false;

		Node(int value) {
			this.value = value;
		}
	}
}
