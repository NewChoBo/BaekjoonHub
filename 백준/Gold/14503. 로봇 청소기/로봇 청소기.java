import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[][] map;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input1[0];  // 세로(x)
        M = input1[1];  // 가로(y)

        // 처음 위치 r, c, 바라보는 방향 d (0: 북, 1:동, 2: 남, 3: 서)
        int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = input2[0];
        int c = input2[1];
        int d = input2[2];

        // 0: 청소 안됨
        // 1: 벽
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로봇청소기가 바라보는 방향
        // 가장 북/서: 0, 0
        // 가장 남/동: N-1, M-1
        /**
         * 동작 규칙
         * 1. 현재 칸 청소 (청소 안된 경우)
         * 2. 현재 주변에 다 청소 되어있는 경우
         *  1. 한 칸 후진 후 현재 칸 청소
         *  2. 벽이라 후진 불가하면 동작 중단
         * 3. 청소 안된 칸이 있는 경우
         *  1. 반시계방향 90도 회전
         *  2. 앞이 청소되지 않았으면 전진
         *
         * 청소한 칸 수 출력
         */
        Robot robot = new Robot(r, c, d);

        while (true) {
            robot.clean();
            boolean checkDirty = robot.isDirty();
            if (checkDirty) {   // 갈 수 있는 곳 중에서 더러운 장소 있음
                robot.turnLeft();
                if (robot.getForward() == 0) {
                    robot.moveForward();
                }
            } else {    // 더러운 장소 없음
                if (!robot.moveBack()) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    static class Robot {
        // (0: 북, 1:동, 2: 남, 3: 서)
        static int[][] mover = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int x, y, d;

        Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        // 시계 반대방향 회전
        void turnLeft() {
            d--;
            if (d < 0) d = 3;
        }

        // 앞 숫자 확인
        int getForward() {
            int[] move = mover[d];
            int tempX = x + move[0];
            int tempY = y + move[1];
            if (validLocation(tempX, tempY)) {
                return map[tempX][tempY];
            }
            return -1;
        }

        // 앞으로 이동
        void moveForward() {
            int[] move = mover[d];
            x += move[0];
            y += move[1];
        }

        boolean moveBack() {
            int[] move = mover[d];
            x -= move[0];
            y -= move[1];

            if (!validLocation(x, y) || map[x][y] == 1) {
                return false;
            }
            return true;
        }

        void clean() {
            if (map[x][y] == 0) {
                cnt++;
                map[x][y] = -1;
            }
        }

        boolean isDirty() {
            for (int[] move : mover) {
                int tempX = x + move[0];
                int tempY = y + move[1];
                if (validLocation(tempX, tempY) && map[tempX][tempY] == 0) {
                    return true;
                }
            }
            return false;
        }

        boolean validLocation(int x, int y) {
            if ((x < 0 || x >= N || y < 0 || y >= M) || map[x][y] == 1) {
                return false;
            }
            return true;
        }
    }
}