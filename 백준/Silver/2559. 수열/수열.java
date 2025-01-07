import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = Integer.MIN_VALUE;

        int index = 0;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        if (max < sum) {
            max = sum;
        }

        for(int i=0; i<N-K; i++) {
            sum -= arr[i];
            sum += arr[i+K];
            if (max < sum) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
