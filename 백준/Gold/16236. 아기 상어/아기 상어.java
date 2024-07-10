import java.io.*;
import java.util.*;

public class Main {
    static final int[][] moveList = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};  // 큐에 넣을 이동 경로
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int N;
    static int totalMove = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] sharckPosition = getSharkPosition();  // 초기 상어 위치


        /**
         * 물고기 먹는 규칙
         * 1. 가까운 물고기
         * 2. 거리가 동일한 경우 상단, 좌측부터
         *
         * 이동 규칙
         * 1. 0은 이동 가능
         * 2. 상어보다 큰 공간은 지나갈 수 없음
         *
         * DFS 순회와 유사할 것으로 추정
         * 가장 우선순위가 높은 곳으로 이동할 것
         * 큐의 각 원소는 현재 위치까지의 이동거리, // 방문처리는 어떻게 하지? long 활용하고, 각 순회마다 고유값 부여한다? 말이 안되는데. 출발지부터 현재 위치까지 이동한 좌표를 set에 담아둔다면?
         *
         * 이동할 위치를 queue에 넣는다.
         * 해당 위치가 이동 가능한 곳인지 판별한다. ( + 물고기는 먹을 수 있는지)
         */
        int sharkLevel = 2;
        int exp = 0;
        while (sharckPosition != null) {
            int[][] visit = new int[N][N];  // 방문 처리를 위한 배열
            for (int i = 0; i < N; i++) {
                Arrays.fill(visit[i], Integer.MAX_VALUE);  // 모든 방문 위치를 무한대로 초기화
            }
            sharckPosition = bfs(visit, new Checker(sharkLevel, exp, sharckPosition, 0));

            // 매 순회마다 물고기를 먹었을 것이므로, 경험치 +1
            exp++;
            if (sharkLevel == exp) {
                sharkLevel++;
                exp = 0;
            }
        }

        System.out.println(totalMove);
    }

    static int[] getSharkPosition() {       // 상어 위치 확인 및 크기별 물고기 마리수 카운트
        int[] position = new int[2];
        for (int i = 0; i < N; i++) {
            int[] line = map[i];
            for (int j = 0; j < N; j++) {
                if (line[j] == 9) {
                    position[0] = i;
                    position[1] = j;
                    map[i][j] = 0;
                    return position;
                }
            }
        }
        return null;        // 탐색 실패
    }

    static int[] bfs(int[][] visit, Checker checker) {
        Queue<Checker> queue = new ArrayDeque<>();
        Queue<int[]> priorityQueue = new PriorityQueue<>(new QueueComparator()); // 먹을 수 있는 물고기 위치 수집
        queue.add(checker);

        int MIN_LENGTH = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Checker currentChecker = queue.poll();
            int[] position = currentChecker.position;
            int sharkLevel = checker.sharkLevel;

            for (int[] toGo : moveList) {
                int[] newPosition = new int[]{toGo[0] + position[0], toGo[1] + position[1]};
                int distance = currentChecker.distance + 1;
                if (!checkValid(newPosition)) continue;

                // 방문여부 확인 및 방문 처리  // visit에 거리를 저장
                if (visit[newPosition[0]][newPosition[1]] <= distance) {
                    continue;
                }
                visit[newPosition[0]][newPosition[1]] = distance;

                // 먹을 수 있는 물고기인지 확인 (먹을 수 있으면 최소값 갱신)
                if (map[newPosition[0]][newPosition[1]] != 0 && map[newPosition[0]][newPosition[1]] < sharkLevel) {
                    if (distance > MIN_LENGTH) continue;
                    if (distance < MIN_LENGTH) {
                        priorityQueue = new PriorityQueue<>(new QueueComparator());
                        MIN_LENGTH = distance;
                    }
                    priorityQueue.add(newPosition);
                    continue;
                }

                // 최소 거리보다 길면 스킵
                if (distance > MIN_LENGTH) {
                    continue;
                }

                // 못가는 지역 확인 (물고기가 더 큼)
                if (map[newPosition[0]][newPosition[1]] > sharkLevel) {
                    continue;
                }

                queue.add(new Checker(checker.sharkLevel, checker.exp, newPosition, currentChecker.distance + 1));
            }
        }

        if (priorityQueue.isEmpty()) {
            return null;
        }


        // 먹은 물고기 맵에서 제거
        int[] result = priorityQueue.poll();
        map[result[0]][result[1]] = 0;
        totalMove += MIN_LENGTH;
        return result;
    }

    static boolean checkValid(int[] position) {
        return position[0] >= 0 && position[0] < N && position[1] >= 0 && position[1] < N;
    }

    static class Checker {
        int sharkLevel;
        int exp;
        int[] position;
        int distance;

        Checker(int sharkLevel, int exp, int[] position, int distance) {
            this.sharkLevel = sharkLevel;
            this.exp = exp;
            this.position = position;
            this.distance = distance;
        }
    }

    static class QueueComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        }
    }
}