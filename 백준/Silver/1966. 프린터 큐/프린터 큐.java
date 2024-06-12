import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int a = 0; a < T; a++) {    // 테스트케이스만큼 반복
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int N = arr[0];    // 문서의 갯수
			int M = arr[1];    // 문서의 위치

			// 중요도는 1~9
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] priorityCounter = new int[10];
			int priory = arr[M];
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 0; i < arr.length; i++) {
				priorityCounter[arr[i]]++;
				if (i == M)
					arr[i] = -1;
				queue.add(arr[i]);
			}

			int currentPriority = 9;
			int cnt = 0;
			while (true) {
				while (priorityCounter[currentPriority] == 0) {
					currentPriority--;
				}
				if (currentPriority == priory)
					break;
				int value = queue.poll();
				if (value == currentPriority) {
					priorityCounter[currentPriority]--;
					cnt++;
				} else {
					queue.add(value);
				}
			}
			while (true) {
				int value = queue.poll();
				if (value == currentPriority) {
					cnt++;
				} else if (value == -1) {
					cnt++;
					break;
				} else {
					queue.add(value);
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
	}
}
