import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    // GPT: 비트연산자로 변환
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int R, C;
    static char[][] map;
    static int max = 1;

    static int[][] mover = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = input1[0];
        C = input1[1];
        map = new char[R][];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Point start = new Point(0, 0, 1 << (map[0][0] - 'A'));  // 1을 map[0][0]의 인덱스만큼 좌측으로 이동 (3이였다면 1000 이런 식으로 기록되고, 1인 값은 방문한 값)
        Stack<Point> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            Point point = stack.pop();
            for (int[] move : mover) {
                int x = move[0] + point.x;
                int y = move[1] + point.y;
                if (!isValid(x, y)) continue;

                int newCharBit = 1 << (map[x][y] - 'A'); // 이번에 방문한 인덱스를 만듦
                if ((point.visited & newCharBit) != 0) continue;    //  양쪽 비트 모두 1인 경우만 남긴 비트가 0이 아니면, 중복된게 있다는 소리

                int newVisited = point.visited | newCharBit;    // 두 비트 중 하나라도 1이면 1 (한번이라도 포함되었으면)
                stack.add(new Point(x, y, newVisited));
                int cnt = Integer.bitCount(newVisited); // 비트 수 확인
                if (cnt > max) max = cnt;
            }
        }

        System.out.println(max);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    static class Point {
        int x, y;
        int visited;

        Point(int x, int y, int visited) {
            this.x = x;
            this.y = y;
            this.visited = visited;
        }
    }
}