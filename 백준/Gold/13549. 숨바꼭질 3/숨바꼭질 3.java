import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] arr;
    static int K;
    static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0]; // 수빈 위치
        K = input[1]; // 동생 위치
        arr = new int[MAX];
        Arrays.fill(arr, -1);

        // 마찬가지로 너비우선 탐색
        // 예제: 5 17, 2
        // 수빈이가 5-10-9-18-17 순으로 가면 2초만에 동생을 찾을 수 있다.
        // 2*x로 이동할 때는 0초
        // +1, -1로 이동할때는 1초
        Queue<PositionTime> queue = new ArrayDeque<>();
        queue.add(new PositionTime(N, 0));
        int time = findBrother(queue);
        System.out.println(time);
    }

    public static int findBrother(Queue<PositionTime> queue) {
        while (!queue.isEmpty()) {
            PositionTime positionTime = queue.poll();
            int position = positionTime.position;
            int time = positionTime.time;


            if (position == K) {
                return time;
            }
            if (arr[position] != -1) continue;
            arr[position] = time;

            // 0초 안에 갈 수 있는 곳들 목적지 추가
            int tempPosition = position * 2;
            if (position != 0) {
                while (tempPosition <= MAX) {
                    if (arr[tempPosition] == -1) {
                        queue.offer(new PositionTime(tempPosition, time));
                    }
                    tempPosition *= 2;
                }
            }
            time++;
            if (position - 1 >= 0 && arr[position - 1] == -1) {
                queue.offer(new PositionTime(position - 1, time));
            }
            if (position + 1 < MAX && arr[position + 1] == -1) {
                queue.offer(new PositionTime(position + 1, time));
            }
        }
        return -1;
    }
}

class PositionTime {
    public int position;
    public int time;

    public PositionTime(int position, int time) {
        this.position = position;
        this.time = time;
    }
}