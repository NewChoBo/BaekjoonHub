import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int sum = 1;
        for (int i = a; i <= b; i++) {
            int no = 0;
            for (int j = 1; j <= i; j++) {
                no += j;
            }
            sum *= (no % 14579);
            sum %= 14579;
        }
        System.out.println(sum);
    }
}