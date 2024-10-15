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
        City[] cities = new City[N + 1];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City();
        }

        for (int i = 0; i < M; i++) {
            // 버스 출발 도시, 버스 도착 도시, 버시 비용 (비용은 0초과 100000미만)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            City city = cities[startCity];
            int prevCost = city.busMap.getOrDefault(endCity, Integer.MAX_VALUE);
            if (prevCost > cost) city.busMap.put(endCity, cost);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Stack<Integer> stack = new Stack();
        cost[startCity] = 0;
        stack.add(startCity);

        while (!stack.isEmpty()) {
            int currentCity = stack.pop();
            Map<Integer, Integer> currentBusMap = cities[currentCity].busMap;
            for (Map.Entry<Integer, Integer> bus : currentBusMap.entrySet()) {
                int key = bus.getKey();
                int value = bus.getValue();

                if (cost[key] > cost[currentCity] + value) {
                    cost[key] = cost[currentCity] + value;
                    stack.add(key);
                }
            }
        }

        System.out.println(cost[endCity]);
    }

    static class City {
        // 도착지, 가격
        Map<Integer, Integer> busMap = new HashMap<>();
    }
}