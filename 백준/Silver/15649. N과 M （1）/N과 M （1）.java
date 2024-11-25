import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        // 1부터 N까지 수 중에서 중복 없이 M개를 고른 수열
        // 고른 수열은 오름차순
        // ==> 백트래킹
        for (int i = 1; i <= N; i++) {
            Set<Integer> hashSet = new HashSet<>();
            hashSet.add(i);
            createArr(new ArrayList<>(), i, hashSet);
            hashSet.remove(i);
        }
        System.out.println(sb);
    }

    static void createArr(List<Integer> list, int current, Set<Integer> integerSet) {
        list.add(current);
        if (list.size() >= M) {
            for (int num : list) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (integerSet.contains(i)) {
                continue;
            }
            integerSet.add(i);
            createArr(list, i, integerSet);
            list.remove(list.size() - 1);
            integerSet.remove(i);
        }
    }
}