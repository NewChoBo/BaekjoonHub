import java.io.*;

public class Main {
    // https://www.acmicpc.net/problem/30802

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int input = Integer.parseInt(br.readLine());
        int cnt2 = 0;
        int cnt5 = 0;

        for (int i = 1; i <= input; i++) {
            cnt2 += getCnt(i, 2);
            cnt5 += getCnt(i, 5);
        }
        System.out.println(Math.min(cnt2, cnt5));
    }

    static int getCnt(int original, int divNo) {
        int cnt = 0;

        while (original % divNo == 0) {
            original /= divNo;
            cnt++;
        }

        return cnt;
    }
}