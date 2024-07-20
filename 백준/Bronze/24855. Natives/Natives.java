import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        line = Arrays.stream(line).sorted().toArray();
        int sum = 0;
        for (int i = ((n + 1) / 2); i < n; i++) {
            sum += line[i];
        }
        System.out.println(sum);
    }
}
