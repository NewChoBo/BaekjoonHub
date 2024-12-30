import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 초기화
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 스트릭프리즈 당일 사용 가능
        int coolTime = 0;
        int max = 0;
        int current = 0;
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            coolTime -= 1;
            if (num == 0) {
                if (coolTime > 0) {
                    current = 0;
                } else {
                    coolTime = 2;
                }
            } else {
                current += 1;
            }
            if(max < current) max = current;
        }

        System.out.println(max);
    }
}