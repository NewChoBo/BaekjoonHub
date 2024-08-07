import java.io.*;
import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 이번엔 처음 쓰는 라이브러리를 사용해보았다.
    // 바로 treeMap. key에 순서가 부여되어있어, 내가 원하는 것보다 큰/작은 키를 찾아 작업할 수 있다는 특징이 있다.
    // 작은 key 값만 set으로 가져와서 활용하는것도 가능하다.

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
            int currentHeight = line[i];    // 현재 높이 확인
            Integer height = map.ceilingKey(currentHeight); // 자신과 같거나 큰 수 중 가장 작은 값
            
            if (height == null) {   // 자신과 같거나 큰 항목이 없는 경우
                sb.append(0);
            } else {    // 자신보다 큰 항목을 찾은 경우
                sb.append(map.get(height) + 1);
            }
            sb.append(" ");

            map.headMap(currentHeight).clear();    // 특정 값보다 작은 모든 키를 제거합니다.
            map.put(currentHeight, i);  // 자기 자신을 Map에 추가합니다.

        }
        System.out.println(sb);
    }
}