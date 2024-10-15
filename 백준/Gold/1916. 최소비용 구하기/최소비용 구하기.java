import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());    // 도시 번호는 1~N
        int M = Integer.parseInt(br.readLine());

        // 도시 초기화
        Map<Integer, Integer>[] cities = new HashMap[N + 1];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new HashMap<>();
        }

        for (int i = 0; i < M; i++) {
            // 버스 출발 도시, 버스 도착 도시, 버시 비용 (비용은 0초과 100000미만)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> city = cities[startCity];
            int prevCost = city.getOrDefault(endCity, Integer.MAX_VALUE);
            if (prevCost > cost) city.put(endCity, cost);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Queue<Integer> queue = new ArrayDeque<>();
        cost[startCity] = 0;
        queue.add(startCity);

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();
            Map<Integer, Integer> currentBusMap = cities[currentCity];
            for (Map.Entry<Integer, Integer> bus : currentBusMap.entrySet()) {
                int key = bus.getKey();
                int value = bus.getValue();

                if (cost[key] > cost[currentCity] + value) {
                    cost[key] = cost[currentCity] + value;
                    queue.add(key);
                }
            }
        }

        System.out.println(cost[endCity]);
    }
}