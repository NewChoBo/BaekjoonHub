import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder resSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        // N까지의 자연수 중에서 M개를 고른 수열
        buildArray(N, M, new int[M], 0);

        System.out.print(resSb);
    }

    static void buildArray(int N, int M, int[] array, int index) {
        if (index == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : array) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            resSb.append(sb);
            return;
        }
        for (int i = 1; i <= N; i++) {
            array[index] = i;
            buildArray(N, M, array, index + 1);
        }
    }
}