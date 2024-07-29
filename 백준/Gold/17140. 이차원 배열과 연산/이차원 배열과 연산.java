import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int r, c, k;
	static int[][] A = new int[100][];
	static int maxCol = 2;
	static int maxRow = 2;

	static Queue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
		if (o1[1] != o2[1]) {
			return o1[1] - o2[1];
		}
		return o1[0] - o2[0];
	});

	public static void main(String[] args) throws IOException {
		init();

		if (A[r][c] == k) {
			System.out.println(0);
			return;
		}
		for (int i = 1; i < 101; i++) {
			if (maxRow >= maxCol) {
				actionR();
			} else {
				actionC();
			}
			if (A[r][c] == k) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

	static void actionR() {
		int newMaxCol = 0;
		for (int i = 0; i < 100; i++) {    // i: 행, col
			int[] counter = new int[101];    // j: 열, row
			for (int j = 0; j < 100; j++) {
				if (A[i][j] != 0) {
					counter[A[i][j]]++;
					if (i > maxCol)
						maxCol = i;
					if (j > maxRow)
						maxRow = j;
				}
			}
			for (int j = 1; j < 101; j++) {
				if (counter[j] != 0) {
					priorityQueue.add(new int[] {j, counter[j]});
				}
			}
			if (!priorityQueue.isEmpty()) {

			}
			int index = 0;
			while (!priorityQueue.isEmpty()) {
				if (index >= 100) {
					priorityQueue.clear();
					break;
				}
				int[] count = priorityQueue.poll();
				A[i][index] = count[0];
				A[i][index + 1] = count[1];
				index += 2;
			}
			newMaxCol = Math.max(newMaxCol, index);
			for (int j = index; j < 100; j++) {
				A[i][j] = 0;
			}
		}
		maxCol = newMaxCol;
	}

	static void actionC() {
		int newMaxRow = 0;
		for (int i = 0; i < 100; i++) {    // i: 행, col
			int[] counter = new int[101];    // j: 열, row
			for (int j = 0; j < 100; j++) {
				if (A[j][i] != 0) {
					counter[A[j][i]]++;
					if (j > maxCol)
						maxCol = j;
					if (i > maxRow)
						maxRow = i;
				}
			}
			for (int j = 1; j < 101; j++) {
				if (counter[j] != 0) {
					priorityQueue.add(new int[] {j, counter[j]});
				}
			}
			int index = 0;
			while (!priorityQueue.isEmpty()) {
				if (index >= 100) {
					priorityQueue.clear();
					break;
				}
				int[] count = priorityQueue.poll();
				A[index][i] = count[0];
				A[index + 1][i] = count[1];
				index += 2;
			}
			newMaxRow = Math.max(newMaxRow, index);
			for (int j = index; j < 100; j++) {
				A[j][i] = 0;
			}
		}
		maxRow = newMaxRow;
	}

	static void init() throws IOException {
		int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		r = input1[0] - 1;
		c = input1[1] - 1;
		k = input1[2];
		for (int i = 0; i < 100; i++) {
			A[i] = new int[100];
		}
		for (int i = 0; i < 3; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			System.arraycopy(input, 0, A[i], 0, 3);
		}
	}
}
