import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        // N명의 사람들이 줄을 서 있다.
        // 인출하는데 걸리는 시간은 P 분이다.
        // ATM 기기는 한개밖에 없다.
        int sum = 0;
        int wait = 0;
        for (int i = 0; i < input.length; i++) {
            wait += input[i];
            sum += wait;
        }
        System.out.println(sum);
    }
}