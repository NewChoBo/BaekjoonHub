import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static final int[][] mover = new int[][]{{}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static final int[] diagonal = new int[]{2, 4, 6, 8};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input1[0];
        M = input1[1];
        map = new int[N][];
        int[][] moveList = new int[M][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < M; i++) {
            moveList[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        /**
         * 모든 구름이 (d 방향으로 s칸 이동한다.)
         * 각 구름에서 비가 내려 구름 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
         * 구름이 사라진다.
         * 물이 증가한 칸에 물 복사버그 마법을 사용. 대각선 방향으로 거리 1인 칸에 바구니 수만큼 (r,c)에 있는 바구니의 물의 양이 증가한다.
         *  바구니에 저장된 물의 양이 2 이상이면 구름 생성, 물 양 감소. 구름 생기는 칸은 이번 루프에서 구름 사라졌던 칸이 아니어야 함
         */
        Set<Cloud> cloudSet = new HashSet<>();
        // 0. 비바라기 시전
        cloudSet.add(new Cloud(N - 1, 0));
        cloudSet.add(new Cloud(N - 1, 1));
        cloudSet.add(new Cloud(N - 2, 0));
        cloudSet.add(new Cloud(N - 2, 1));


        for (int[] move : moveList) {

            // 1. 구름 이동
            int d = move[0];
            int s = move[1];
            for (Cloud cloud : cloudSet) {
                cloud.MoveCloud(d, s);

                // 2. 구름에서 비 내리기
                map[cloud.x][cloud.y]++;
            }

            // 3. 구름 삭제 (추후 교체할 set)
            Set<Cloud> newSet = new HashSet<>();

            // 4. 물이 증가한 칸 (비가 내린 칸)에 물 복사 마법 사용 (대각선 방향으로 거리가 1인 칸에 물 있는 바구니 수 만큼 물 양 증가)
            Set<String> visited = new HashSet<>();
            for (Cloud cloud : cloudSet) {
                int cnt = 0;
                for (int way : diagonal) {
                    int[] go = mover[way];
                    int x = cloud.x + go[0];
                    int y = cloud.y + go[1];
                    if (x < 0 || y < 0 || x >= N || y >= N) continue;
                    if (map[x][y] != 0) cnt++;
                }
                map[cloud.x][cloud.y] += cnt;
                visited.add(cloud.x + "," + cloud.y);
            }

            // 5. 바구니에 저장된 물 양 2 이상이면 구름 만들고, 물 양 2 감소. 3에서 구름 사라졌던 칸은 안됨
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] < 2 || visited.contains(i + "," + j)) continue;
                    Cloud newCloud = new Cloud(i, j);
                    map[i][j] -= 2;
                    newSet.add(newCloud);
                }
            }
            cloudSet = newSet;
        }

        // 출력
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }


    static class Cloud {
        int x, y;

        Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void MoveCloud(int d, int s) {
            int x = this.x;
            int y = this.y;
            int[] move = mover[d];
            x += s * move[0];
            y += s * move[1];

            this.x = (x % N + N) % N;
            this.y = (y % N + N) % N;
        }
    }
}
