import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int[][] mover = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    integerList.add(bfs(i, j));
                }
            }
        }

        // 단지에 속하는 집의 수 오름차순 정렬
        System.out.println(integerList.size());
        integerList.sort(Comparator.naturalOrder());
        for (int num : integerList) {
            System.out.println(num);
        }
    }

    static int bfs(int x, int y) {
        Stack<int[]> points = new Stack<>();
        points.add(new int[]{x, y});
        int cnt = 1;
        map[x][y] = 2;
        while (!points.isEmpty()) {
            int[] current = points.pop();
            for (int[] move : mover) {
                int newX = current[0] + move[0];
                int newY = current[1] + move[1];
                if (newX >= 0 && newY >= 0 && newX < N && newY < N && map[newX][newY] == 1) {
                    map[newX][newY] = 2;
                    cnt++;
                    points.add(new int[]{newX, newY});
                }
            }
        }
        return cnt;
    }
}