import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // V, E
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Map<Integer, Integer>[] mapArr = new Map[V + 1];
        int[] weight = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            mapArr[i] = new HashMap<>();
            weight[i] = Integer.MAX_VALUE;
        }

        int start = Integer.parseInt(br.readLine());
        weight[start] = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());   // 시작
            int v = Integer.parseInt(st.nextToken());   // 도착
            int w = Integer.parseInt(st.nextToken());   // 가중치(10 이하)

            int value = mapArr[u].getOrDefault(v, Integer.MAX_VALUE);
            if (w < value) {
                mapArr[u].put(v, w);
            }
        }

        Queue<Integer> queue = new PriorityQueue<>((Comparator.comparingInt(o -> weight[o])));
        queue.add(start);
        while (!queue.isEmpty()) {
            int point = queue.poll();
            int prevVal = weight[point];
            for (Map.Entry<Integer, Integer> entry : mapArr[point].entrySet()) {
                int key = entry.getKey();
                int value = prevVal + entry.getValue();
                if(weight[key] > value) {
                    weight[key] = value;
                    queue.add(key);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i< weight.length; i++) {
            sb.append(weight[i] == Integer.MAX_VALUE ? "INF" : weight[i]).append('\n');
        }
        System.out.print(sb);
    }
}