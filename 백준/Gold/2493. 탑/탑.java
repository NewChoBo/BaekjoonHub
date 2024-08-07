import java.io.*;
import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 모든 탑은 왼쪽으로 동시에 레이저 신호를 발사한다.
        // 이게 골드 5..? 가 아니라 생각보다 생각할게 있네. 최고점 찍고 작아져도 다음 것보다 클 수 있는거잖아..?
        // dp처럼 생각하면 될지도?   => X
        // 일종의 set에 넣고, 자기보다 작은거 다 지워버리면 될텐데.
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < line.length; i++) {
            NavigableSet<Integer> keySet = map.navigableKeySet();
            int currentHeight = line[i];
            Integer height = keySet.ceiling(currentHeight);
            if (height == null) {
                sb.append(0);
            } else {
                sb.append(map.get(height) + 1);
            }
            // 특정 값보다 작은 모든 키를 제거합니다.
            Set<Integer> keysToRemove = map.headMap(currentHeight).keySet();
            keysToRemove.clear();
            sb.append(" ");
            map.put(currentHeight, i);
        }
        System.out.println(sb.toString());
    }
}