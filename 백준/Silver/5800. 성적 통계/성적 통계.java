import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < K + 1; i++) {
            sb.append("Class ").append(i).append('\n');
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int max = Integer.MIN_VALUE;
            list = list.stream().sorted().collect(Collectors.toList());
            for (int j = 0; j < list.size() - 1; j++) {
                max = Math.max(max, list.get(j + 1) - list.get(j));
            }
            sb.append("Max ").append(list.get(N-1)).append(", Min ").append(list.get(0)).append(", Largest gap ").append(max).append('\n');
        }
        System.out.print(sb);
    }
}