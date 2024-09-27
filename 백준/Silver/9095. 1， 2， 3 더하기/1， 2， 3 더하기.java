import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        // n은 11보다 작다
        int[] counter = new int[12];
        int sum = 0;
        counter[0] = 1;
        counter[1] = 1;
        counter[2] = 2;
        for (int i = 3; i < 12; i++) {
            counter[i] = counter[i - 1] + counter[i - 2] + counter[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int index = Integer.parseInt(br.readLine());
            sb.append(counter[index]).append('\n');
        }
        System.out.print(sb);
    }
}