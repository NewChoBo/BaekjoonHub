import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> numMap = new HashMap<>();

        // 시작-끝 점, max 출력
        int start = 0;
        int max = 0;
        for (int end = 0; end < N; end++) {
            int endNum = line[end];
            numMap.put(endNum, numMap.getOrDefault(endNum, 0) + 1);

            // 시작점 증가
            while (numMap.size() > 2) {
                // 처음 숫자 삭제
                int startNum = line[start];
                int cnt = numMap.get(startNum) - 1;
                if (cnt <= 0) {
                    numMap.remove(startNum);
                } else {
                    numMap.put(startNum, cnt);
                }
                start++;
            }

            if (end - start > max) max = end - start;
        }

        System.out.println(max + 1);

        // 과일의 각 종류에는 1~9의 번호가 붙음
        // 앞에서부터 차례로 S1, S2, ..., Sn 번 과일이 꽂혀있다.
        // 과일을 두 종류 이하로 사용하라.
        // 시간이 없어, 막대의 앞과 뒤에서 몇개의 과일을 빼 2종류 이하의 과일만 남기기로 함.
        // 앞에서 a개, 뒤에서 b개의 과일을 빼면 Sa+1 ~ Sn-b번 (N-(a+b)개 짜리 과일)
        // 슬라이딩 윈도우 형식으로 진행하면 될 것.
        // 과일은 20만개까지 가능
    }
}