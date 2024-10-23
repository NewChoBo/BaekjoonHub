import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Map<Integer, Integer>[] maps = new HashMap[N];
        for (int i = 0; i < N; i++) {
            maps[i] = new HashMap();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            maps[a].put(b, c);
            maps[b].put(a, c);
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()) - 1;
        int v2 = Integer.parseInt(st.nextToken()) - 1;

        int oneToV1 = getMinDistanceBetweenAandB(0, v1, N, maps);
        int v2ToLast = getMinDistanceBetweenAandB(v2, N - 1, N, maps);
        int val1 = Integer.MAX_VALUE;
        if (oneToV1 != Integer.MAX_VALUE && v2ToLast != Integer.MAX_VALUE) {
            val1 = oneToV1 + v2ToLast;
        }

        int oneToV2 = getMinDistanceBetweenAandB(0, v2, N, maps);
        int v1ToLast = getMinDistanceBetweenAandB(v1, N - 1, N, maps);
        int val2 = Integer.MAX_VALUE;
        if (oneToV2 != Integer.MAX_VALUE && v1ToLast != Integer.MAX_VALUE) {
            val2 = oneToV2 + v1ToLast;
        }

        int minVal = Math.min(val1, val2);
        int v1ToV2 = getMinDistanceBetweenAandB(v1, v2, N, maps);
        if (minVal != Integer.MAX_VALUE && v1ToV2 != Integer.MAX_VALUE) {
            System.out.println(minVal + v1ToV2);
        } else {
            System.out.println(-1);
        }
    }

    static int getMinDistanceBetweenAandB(int v1, int v2, int N, Map<Integer, Integer>[] maps) {
        int[] maxArr = new int[N];
        Arrays.fill(maxArr, Integer.MAX_VALUE);
        Queue<Integer> queue = new PriorityQueue<>();
        maxArr[v1] = 0;
        queue.add(v1);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (maxArr[current] >= maxArr[v2]) continue;
            for (Map.Entry<Integer, Integer> entry : maps[current].entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (maxArr[key] > maxArr[current] + value) {
                    maxArr[key] = maxArr[current] + value;
                    queue.add(key);
                }
            }
        }
        return maxArr[v2];
    }
}