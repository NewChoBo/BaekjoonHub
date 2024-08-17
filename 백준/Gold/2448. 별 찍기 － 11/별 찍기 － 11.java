import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		char[][] charMap = new char[N][];
		// 빈 공간 초기화
		for (int i = 0; i < N; i++) {
			charMap[i] = new char[N * 2];
			for (int j = 0; j < charMap[i].length; j++) {
				charMap[i][j] = ' ';
			}
		}

		// 가장 아랫줄 생성
		Queue<Point> pointQueue = new ArrayDeque<>();
		for (int i = 0; i < charMap[0].length - 5; i += 6) {
			Point current = coloring(charMap, new Point(N - 1, i));
			pointQueue.add(current);
		}
		while (pointQueue.peek().x > 0) {
			Point a = pointQueue.poll();
			Point b = pointQueue.poll();
			for (int y = a.y; y < b.y; y += 6) {
				pointQueue.add(coloring(charMap, new Point(a.x, y)));
			}
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (char[] chars : charMap) {
			for (char c : chars) {
				sb.append(c);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static Point coloring(char[][] charMap, Point startPoint) {
		int x = startPoint.x;
		int y = startPoint.y;
		for (int i = y; i < y + 5; i++) {
			charMap[x][i] = '*';
		}
		charMap[x - 1][y + 1] = '*';
		charMap[x - 1][y + 3] = '*';
		charMap[x - 2][y + 2] = '*';

		return new Point(startPoint.x - 3, startPoint.y + 3);
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "{x: " + x + ", y:" + y + "}";
		}
	}
}
