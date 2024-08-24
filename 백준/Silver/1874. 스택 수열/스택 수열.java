import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] sample = new int[n];
		for (int i = 0; i < n; i++) {
			sample[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int current = 1;

		for (int i = 0; i < n; i++) {
			int target = sample[i];

			while (current <= target) {
				stack.push(current++);
				sb.append('+').append('\n');
			}

			if (stack.peek() == target) {
				stack.pop();
				sb.append('-').append('\n');
			} else {
				System.out.println("NO");
				return;
			}
		}

		System.out.print(sb);
	}
}
