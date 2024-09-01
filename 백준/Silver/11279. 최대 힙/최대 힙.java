import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (queue.isEmpty()) {
					sb.append(0);
				} else {
					sb.append(queue.poll());
				}
				sb.append('\n');
			} else {
				queue.add(num);
			}
		}
		System.out.print(sb);
	}
}
