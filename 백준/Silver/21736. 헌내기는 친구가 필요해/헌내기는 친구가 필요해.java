import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 0. 입력값 초기화
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input1[0];
        int M = input1[1];
        char[][] map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            // O는 빈 공간, x는 벽, I는 도연, P는 사람. I는 한번만 주어짐
        }

        // 1. 도연이 위치 찾기
        Point iPoint = getIPoint(map);

        // 2. 도연이의 위치에서 이동하여 만날 수 있는 P의 개수 세기
        int cnt = getPeopleCnt(map, iPoint);

        // 3. 출력
        System.out.println(cnt == 0 ? "TT" : cnt);
    }

    static int getPeopleCnt(char[][] map, Point iPoint) {
        boolean[][] visitedMap = new boolean[map.length][map[0].length];
        int cnt = 0;

        Stack<Point> stack = new Stack<>();
        iPoint.setVisited(visitedMap);
        stack.push(iPoint);
        while (!stack.isEmpty()) {
            Point currentPoint = stack.pop();
            List<Point> availableNeighbor = currentPoint.getAvailableNeighbor(map, visitedMap);
            for (Point neighbor : availableNeighbor) {
                stack.push(neighbor);
                if (map[neighbor.x][neighbor.y] == 'P') cnt++;
            }
        }

        return cnt;
    }

    static Point getIPoint(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'I') {
                    return new Point(i, j);
                }
            }
        }
        return new Point(-1, -1);
    }

    static class Point {
        static int[][] mover = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setVisited(boolean[][] visitedMap) {
            visitedMap[x][y] = true;
        }

        List<Point> getAvailableNeighbor(char[][] map, boolean[][] visitedMap) {
            List<Point> result = new ArrayList<>();
            for (int[] move : mover) {
                int x = this.x + move[0];
                int y = this.y + move[1];

                // 지도 범위 탈출 검사
                if (x < 0 || y < 0 || x >= map.length || y >= map[x].length) {
                    continue;
                }

                // 벽 또는 방문 여부 확인(갈 수 있는 위치인지 확인)
                if (map[x][y] == 'X' || visitedMap[x][y]) {
                    continue;
                }

                // 조건에 부합하므로 결과에 추가
                Point newPoint = new Point(x, y);
                result.add(newPoint);
                newPoint.setVisited(visitedMap);
            }

            return result;
        }
    }
}
