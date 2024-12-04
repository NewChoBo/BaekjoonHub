import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// https://www.acmicpc.net/problem/14890
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());   // 경사로의 길이
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer lineToken = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(lineToken.nextToken());
			}
		}

		// 경사로의 바닥이 모두 접해야 한다
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			Point[] points1 = new Point[N];
			Point[] points2 = new Point[N];
			for (int j = 0; j < N; j++) {
				points1[j] = new Point(map[i][j]);
				points2[j] = new Point(map[j][i]);
			}

			if (canGoThrew(points1, L)) {
				cnt++;
			}
			if (canGoThrew(points2, L)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static boolean canGoThrew(Point[] points, int L) {
		int height = points[0].height;
		for (int i = 1; i < points.length; i++) {
			if (points[i].height == height) {
				continue;
			}
			if (Math.abs(height - points[i].height) >= 2) {
				return false;     // 높이 차이가 2 이상이면 실패
			}
			if (height < points[i].height) {    // 높이가 높아진 경우
				int start = i - L;
				if (start < 0) {
					return false;    // 시작지점 범위 초과
				}
				for (int j = start; j < i; j++) {
					if (points[j].slope || points[j].height != height) {
						return false;
					}
					points[j].slope = true;
				}
			} else {    // 높이가 낮아진 경우
				int end = i + L;
				if (end > points.length) {
					return false;  // 종료지점 범위 초과
				}
				for (int j = i; j < end; j++) {
					if (points[j].height != points[i].height || points[j].slope) {
						return false;
					}
					points[j].slope = true;
				}
			}
			height = points[i].height;
		}
		return true;
	}

	static class Point {

		int height;
		boolean slope = false;

		Point(int height) {
			this.height = height;
		}
	}
}