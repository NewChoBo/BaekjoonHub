import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] chars = new char[R][];
        for (int i = 0; i < R; i++) {
            chars[i] = br.readLine().toCharArray();
        }
        // 첫글자는 S, 출발선
        // 마지막 글자는 F, 결승선
        // 물은 .
        int[] arr = new int[10];
        int rank = 1;
        for (int i = C - 2; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < R; j++) {
                if (chars[j][i] != '.') {
                    int num = chars[j][i] - '0';
                    if (arr[num] == 0) {
                        flag = true;
                        arr[num] = rank;
                    }
                }
            }
            if (flag) {
                rank++;
            }
        }
        for (int i = 1; i <= 9; i++) {
            System.out.println(arr[i]);
        }
    }
}