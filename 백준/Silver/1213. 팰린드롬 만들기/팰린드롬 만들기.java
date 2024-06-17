import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		char[] input = br.readLine().toCharArray();
		int[] counter = new int[26];
		for (char c : input) {
			counter[c - 'A']++;
		}

		int oddCount = 0;
		int oddNum = -1;
		for (int i = 0; i < 26; i++) {
			int num = counter[i];
			if (num % 2 == 1) {
				oddCount++;
				oddNum = i;
			}
		}

		// 만들 수 없는 경우 걸러냄
		if (oddCount > 1) {
			bw.write("I'm Sorry Hansoo");
			bw.flush();
			return;
		}

		// 만들기
		Queue<Integer> queue = new ArrayDeque<>();
		Stack<Integer> stack = new Stack<>();
		int middle = -1;
		for (int i = 0; i < 26; i++) {
			while (counter[i] > 1) {
				counter[i] -= 2;
				queue.add(i);
				stack.push(i);
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		while (!queue.isEmpty()) {
			stringBuilder.append(Character.toChars(queue.poll() + 'A'));
		}
		if (oddNum != -1)
			stringBuilder.append(Character.toChars(oddNum + 'A'));
		while (!stack.isEmpty()) {
			stringBuilder.append(Character.toChars(stack.pop() + 'A'));
		}
		bw.write(stringBuilder.toString());
		bw.flush();
	}
}
