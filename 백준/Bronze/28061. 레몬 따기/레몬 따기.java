import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] cnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        for (int i = 1; i <= cnt.length; i++) {
            int current = cnt[N - i] - i;
            if (current > max) max = current;
        }
        System.out.println(max);
    }
}