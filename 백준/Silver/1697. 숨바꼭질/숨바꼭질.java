import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];   // 수빈 위치
        int K = input[1];   // 동생 위치
        int[] road = new int[100001];
        Arrays.fill(road, Integer.MAX_VALUE);

        // 걷거나 순간이동 가능
        Queue<Integer> integerQueue = new ArrayDeque<>();
        road[N] = 0;
        integerQueue.add(N);

        while (!integerQueue.isEmpty()) {
            int current = integerQueue.poll();
            int cnt = road[current] + 1;
            int[] rotate = new int[]{current - 1, current + 1, current * 2};
            for (int newPoint : rotate) {
                if (isValid(newPoint) && road[newPoint] > cnt) {
                    road[newPoint] = cnt;
                    integerQueue.add(newPoint);
                }
            }
        }
        System.out.println(road[K]);
    }

    static boolean isValid(int current) {
        if (current < 0 || current > 100000) return false;
        return true;
    }
}