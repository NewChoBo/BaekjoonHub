import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num + 1];
		boolean[] booleans = new boolean[num + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);

		// a. 3으로 나눌 수 있으면 3으로 나눔
		// b. 2로 나눌 수 있으면 2로 나눔
		// c. 둘 다 안되면 1을 뺌
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		arr[1] = 0;

		while (!queue.isEmpty()) {
			int no = queue.poll();
			int no1 = no + 1;
			int no2 = no * 2;
			int no3 = no * 3;

			try {
				if (!booleans[no1]) {
					arr[no1] = arr[no] + 1;
					booleans[no1] = true;
					queue.add(no1);
				}
			} catch (Exception e) {
			}
			try {
				if (!booleans[no2]) {
					arr[no2] = arr[no] + 1;
					booleans[no2] = true;
					queue.add(no2);
				}
			} catch (Exception e) {
			}
			try {
				if (!booleans[no3]) {
					arr[no3] = arr[no] + 1;
					booleans[no3] = true;
					queue.add(no3);
				}
			} catch (Exception e) {
			}

			if (booleans[num]) {
				break;
			}
		}
		System.out.println(arr[num]);
	}
}
