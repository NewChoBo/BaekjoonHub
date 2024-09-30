import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 파도반 수열
        // 가장 긴 변: K
        // 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
        // 1, 1, 1, 2, 2, (1+2), (1+3), (1+4), (2+5), (2+7), (3+9), (4+12), (5+16)...
        // N은 100 이하
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;
        arr[7] = 4;
        arr[8] = 5;
        arr[9] = 7;
        arr[10] = 9;
        for (int i = 11; i <= 100; i++) {
            arr[i] = arr[i-1] + arr[i-5];
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append('\n');
        }
        System.out.print(sb);
    }
}