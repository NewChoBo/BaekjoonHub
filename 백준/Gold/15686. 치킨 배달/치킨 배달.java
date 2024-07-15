import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static Queue<Queue<Position>> cases = new ArrayDeque<>();
	static int[][] mover = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input1[0];
		int M = input1[1];

		// 치킨거리: 각 집에서 가장 가까운 치킨집 사이의 거리
		// 0은 빈칸, 1은 집, 2는 치킨집

		// 도시의 치킨 거리는 모든 집의 치킨거리의 합
		// M개의 치킨집만 남길 것. 나머지는 폐업. 어떻게 골라야 도시의 치킨 거리가 가장 작게 되나?
		int[][] map = new int[N][];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		List<Position> chickenList = new ArrayList<>();
		List<Position> houseList = new ArrayList<>();
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] == 1) {
					houseList.add(new Position(x, y));
				} else if (map[x][y] == 2) {
					chickenList.add(new Position(x, y));
					map[x][y] = 0;
				}
			}
		}

		// 치킨집 중 M개를 선택하는 모든 경우의 수 반복
		// 각 집에서 가장 가까운 치킨집 확인
		Position[] positions = chickenList.toArray(new Position[0]);
		backTracking(positions, M, new ArrayDeque<>(), -1);
		int MIN_DISTANCE = Integer.MAX_VALUE;
		for (Queue<Position> chickens : cases) {
			// 맵 초기화
			int[][] currentMap = initMap(map, chickens);

			// 모든 집에 대해서, 가장 가까운 치킨집을 찾는 순회
			int sum = 0;
			for (Position house : houseList) {
				sum += bfs(currentMap, new ArrayDeque<>(), house);
			}
			if (MIN_DISTANCE > sum)
				MIN_DISTANCE = sum;
		}
		System.out.println(MIN_DISTANCE);
	}

	static int bfs(int[][] map, Queue<Position> positions, Position house) {
		int N = map.length;

		// 방문처리를 위한 2차원 배열 생성
		boolean[][] visit = new boolean[N][];
		for (int i = 0; i < N; i++) {
			visit[i] = new boolean[N];
		}

		// bfs를 위한 Queue 초기화
		Queue<Position> queue = new ArrayDeque<>();
		queue.add(house);
		visit[house.x][house.y] = true;

		while (!queue.isEmpty()) {
			Position position = queue.poll();

			int distance = position.distance + 1;
			for (int[] move : mover) {
				int x = move[0] + position.x;
				int y = move[1] + position.y;

				if (x < 0 || x >= N || y < 0 || y >= N) {    // 범위 초과
					continue;
				}
				if (visit[x][y])    // 이미 방문
					continue;

				if (map[x][y] == 2)    // 치킨집 도착
					return distance;

				visit[x][y] = true;
				queue.add(new Position(x, y, distance));
			}
		}
		return 0;
	}

	static void backTracking(Position[] chickenList, int M, Queue<Position> currentQueue, int currentIndex) {
		if (currentQueue.size() == M) {
			cases.add(currentQueue);
			return;
		}
		for (int i = currentIndex + 1; i < chickenList.length; i++) {
			Queue<Position> newQueue = new ArrayDeque<>(currentQueue);
			newQueue.add(chickenList[i]);
			backTracking(chickenList, M, newQueue, i);
		}
	}

	static int[][] initMap(int[][] map, Queue<Position> positions) {
		int[][] newMap = new int[map.length][];
		for (int i = 0; i < newMap.length; i++) {
			newMap[i] = map[i].clone();
		}
		while (!positions.isEmpty()) {
			Position chicken = positions.poll();
			newMap[chicken.x][chicken.y] = 2;
		}
		return newMap;
	}

	static class Position {
		int x;
		int y;
		int distance = 0;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Position(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		Position clone(Position position) {
			return new Position(position.x, position.y);
		}
	}
}
