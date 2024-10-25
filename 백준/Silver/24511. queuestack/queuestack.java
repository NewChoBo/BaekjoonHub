import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayDeque<Integer> valueQueue = new ArrayDeque<>();
    static StringTokenizer valueTokens;

    public static void main(String[] args) {
        init();
        solve();
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int value = Integer.parseInt(valueTokens.nextToken());
            valueQueue.add(value);
            int result = valueQueue.poll();
            sb.append(result).append(' ');
        }
        System.out.print(sb);
    }

    static void init() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int type = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st2.nextToken());
                if (type == 0) {
                    valueQueue.addFirst(value);
                }
            }
            M = Integer.parseInt(br.readLine());
            valueTokens = new StringTokenizer(br.readLine());
        } catch (Exception e) {
            System.out.println("입력 잘못받았습니다.");
        }
    }
}