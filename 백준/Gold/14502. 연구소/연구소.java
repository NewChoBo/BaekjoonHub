import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int MAX_VAL = Integer.MIN_VALUE;
    static List<int[]> VIRUS_POINT_LIST = new ArrayList<>();
    static int[][] VIRUS_MOVE = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int N, M;

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input1[0];
        M = input1[1];
        int[][] map = new int[N][];

        // 초기 지도 입력
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // 바이러스 위치 queue에 삽입
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    VIRUS_POINT_LIST.add(new int[]{i, j});
                }
            }
        }

        // 0은 빈 공간, 1은 벽, 2는 바이러스
        // 빈 공간에 3개의 벽을 세우는 모든 경우의 수 순회
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {   // 1번 벽
                if (map[i][j] != 0) continue;
                int[][] newMap = cloneArr(map);
                newMap[i][j] = 1;

                for (int i1 = 0; i1 < N; i1++) {
                    for (int j1 = 0; j1 < M; j1++) {
                        if (newMap[i1][j1] != 0) continue;
                        int[][] newMap2 = cloneArr(newMap);
                        newMap2[i1][j1] = 1;

                        for (int i2 = 0; i2 < N; i2++) {
                            for (int j2 = 0; j2 < M; j2++) {
                                if (newMap2[i2][j2] != 0) continue;
                                int[][] newMap3 = cloneArr(newMap2);
                                newMap3[i2][j2] = 1;
                                dfs(newMap3);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(MAX_VAL);
    }

    static int[][] cloneArr(int[][] arr) {
        int[][] newArr = new int[arr.length][];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i].clone();
        }
        return newArr;
    }

    static void dfs(int[][] map) {
        // 바이러스들 queue 삽입 후 파이러스 확산
        Queue<int[]> queue = new ArrayDeque<>(VIRUS_POINT_LIST);

        while (!queue.isEmpty()) {
            int[] virusPoint = queue.poll();
            for (int[] move : VIRUS_MOVE) {
                int x = move[0] + virusPoint[0];
                int y = move[1] + virusPoint[1];
                if (x < 0 || y < 0 || x >= N || y >= M) {
                    continue;
                }
                if (map[x][y] != 0) continue;
                map[x][y] = 2;
                int[] newPoint = new int[]{x, y};
                queue.add(newPoint);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) result++;
            }
        }
        if (MAX_VAL < result) {
            MAX_VAL = result;
        }
    }
}