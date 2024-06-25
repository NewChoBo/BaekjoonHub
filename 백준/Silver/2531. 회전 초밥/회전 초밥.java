import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Map<Integer, Integer> counter;

    // 이것도 슬라이딩 윈도우 방식 활용하면 시간 아낄 수 있을지도
    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input1[0];  // 회전 초밥 벨트 위의 수
        int d = input1[1];  // 초밥의 가짓수
        int k = input1[2];  // 연속해서 먹는 접시의 수
        int c = input1[3];  // 쿠폰번호

        // 손님이 먹을 수 있는 초밥 가짓수의 최댓값
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 쿠폰번호에 해당하는 초밥은 무조건 먹을 수 있다.
        // 모든 시작지점을 기준으로 순회 횟수를 카운트 하면 될 것
        counter = new HashMap<Integer, Integer>();

        addPoint(c);
        for (int point = 0; point < k; point++) {
            addPoint(arr[point]);
        }
        int max = counter.size();
        for (int start = 0; start < N; start++) {
            int end = (start + k) % N;  // 끝 점은 항상 i + k

            popPoint(arr[start]);
            addPoint(arr[end]);
            int cnt = counter.size();
            if (cnt > max) {
                max = cnt;
                if (max == d) break;
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }

    static void addPoint(int value) {
        if (!counter.containsKey(value)) {
            counter.put(value, 0);
        }
        counter.put(value, counter.get(value) + 1);
    }

    static void popPoint(int value) {
        counter.put(value, counter.get(value) - 1);
        if (counter.get(value) == 0) counter.remove(value);
    }
}