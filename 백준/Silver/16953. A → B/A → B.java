import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = input[0];
        int B = input[1];

        // 역으로 B에서 A로 변환하는 경우의 수
        // 끝자리가 1인 경우
        // 2로 나누어 떨어지는 경우
        int cnt = 0;
        boolean flag = true;
        while (flag) {
            if (A == B) break;
            if(B == 0) {
                flag = false;
            } else if (B % 10 == 1) {
                B /= 10;
                cnt++;
            } else if (B % 2 == 0) {
                B /= 2;
                cnt++;
            } else {
                flag = false;
            }
        }
        if (flag) {
            System.out.println(cnt + 1);
        } else {
            System.out.println(-1);
        }
    }
}