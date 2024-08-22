import java.io.*;
import java.util.Arrays;

public class Main {
    // https://www.acmicpc.net/problem/30802

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());    // 참가자 수
        int[] line1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();    // 티셔츠 사이즈 별 신청자 수
        int[] line2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int T = line2[0];   // 티셔츠 한 묶음당 개수
        int P = line2[1];   // 펜 한 묶음당 개수

        // 티셔츠 T장씩 최소 몇 묶음?
        // 펜 P 자루씩 최대 몇 묶음? 펜 한 자루씩 몇 개?
        int cntT = 0;
        for (int req : line1) {
            cntT += req / T;
            if (req % T != 0) cntT++;
        }
        System.out.println(cntT);
        System.out.println((N / P) + " " + (N % P));
    }
}