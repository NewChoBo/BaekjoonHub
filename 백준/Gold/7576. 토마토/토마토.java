import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int M, N;

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = input[0];
        N = input[1];

        // 1: 익은 토마토
        // 0: 안익은 토마토
        // -1: 토마토 없음
        int[][] map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        // 시작할때부터 모든 토마토가 익어있으면 0
        // 토마토가 모두 익을 수 없으면 -1 출력

        // 1. for문을 통해 이미 익어있는 토마토 queue에 삽입 (여기서 모두 익어있는지도 검증)
        // 2. 반복문을 돌면서, 큐에 들어있던 토마토와 인접한 안익은 토마토들을 새로운 큐에 삽입 (날짜 +1)
        // 3. 새로 입력받아야 하는 큐가 텅 빌때까지 반복

        Queue<int[]> queue = new ArrayDeque<>();
        int unripeTomato = 0;
        int day = -1;

        // 1. 안익은 토마토 수, 현재 익은 토마토 파악
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                switch (map[i][j]) {
                    case 1:
                        queue.add(new int[]{i, j});
                        break;
                    case 0:
                        unripeTomato++;
                        break;
                }
            }
        }

        // 2. 방문하고 나면 익은 토마토로 처리
        while (!queue.isEmpty()) {
            day++;
            int loopCnt = queue.size();
            for(int i=0; i<loopCnt; i++) {
                // 현 위치 구하기
                int[] currentTomato = queue.poll();
                //인접 미방문 토마토 방문 처리 및 queue 삽입
                unripeTomato = getCloseTomato(queue, map, currentTomato, unripeTomato);
            }
        }
        if (unripeTomato > 0) day = -1;
        bw.write(String.valueOf(day));
        bw.flush();
    }

    private static int getCloseTomato(Queue<int[]> queue, int[][] map, int[] currentPoint, int unripeTomato) {
        int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] point : move) {
            int currentX = currentPoint[0] + point[0];
            int currentY = currentPoint[1] + point[1];
            if(N-1 < currentX || currentX < 0 || M-1 < currentY || currentY < 0) continue;

            int tomato = map[currentX][currentY];
            if (tomato == 0) {
                queue.add(new int[]{currentX, currentY});
                map[currentX][currentY] = 1;
                unripeTomato--;
            }
        }
        return unripeTomato;
    }
}