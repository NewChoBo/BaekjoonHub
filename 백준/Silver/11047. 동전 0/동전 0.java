import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // Ai는 Ai-1의 배수
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];   // 현재 액수

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int coinCnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            coinCnt += K / arr[i];
            K = K % arr[i];
        }
        System.out.println(coinCnt);
    }
}