import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 서강대에는 N개의 창문, N명의 사람
        // 1번째 사람은 1의 배수번째 창문을 열려있으면 닫고 닫혀있으면 연다
        // 2번째 사람은 2의 배수번째 창문을 열려있으면 닫고 닫혀있으면 연다
        // 이런 행동을 N번째 사람까지 한다
        // 열려있는 창문의 개수는 몇개인가? 처음에 창문은 모두 닫혀있다
        // 1 <= N <= 2,100,000,000
        int N = Integer.parseInt(br.readLine());
        int no = 1;
        int cnt = 0;
        while (Math.pow(no, 2) <= N) {
            cnt++;
            no++;
        }
        System.out.println(cnt);

        // 1: [1]
        // 2: [1, 0]
        // 3: [1, 0, 0]
        // 4: [1, 0, 0, 1]
        // 5: [1, 0, 0, 1, 0]
        // 6: [1, 0, 0, 1, 0, 0]
        // 7: [1, 0, 0, 1, 0, 0, 0]
        // 8: [1, 0, 0, 1, 0, 0, 0, 0, 0]
        // 1, 4,  8...
        // 24: 2 * 2 * 2 * 3 -> 4개
    }
}
