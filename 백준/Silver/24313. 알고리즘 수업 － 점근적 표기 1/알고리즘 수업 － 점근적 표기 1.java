import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // O(g(n)) = { f(n) | 모든 n >= n0에 대해 f(n)<= c * g(n) 만족하는 양의 상수 c, n0 존재 }
    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a1 = input1[0];
        int a0 = input1[1];
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        // f(n)=a1(n) + a0
        // f(n) ≤ c × g(n)
        // >>> a1*n + a0 <= c*n ??? g(n)이 의미하는 바가 도대체 무엇이기에???

        if (a1 * n + a0 <= c * n && a1 <= c) {
            System.out.println(1);
            return;
        }
        System.out.println(0);

        // o(n) 만족 1, 아니면 0
    }
}