import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 후보 N명, 주민 M명
        // 다솜은 기호 1, 사람들 매수하려 시도. 득표수 1등일 때 당선
        // 매수해야 하는 사람 최솟값
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());        // 다솜의 득표 수
        int[] counter = new int[101];    // 다솜을 제외한 후보들의 득표 수 배열
        for (int i = 1; i < N; i++) {
            counter[Integer.parseInt(br.readLine())]++;
        }

        int maxVal = counter.length - 1;
        int cnt = 0;
        while (dasom <= maxVal) {
            if (counter[maxVal] == 0) {
                maxVal--;
                continue;
            }
            counter[maxVal]--;
            counter[maxVal - 1]++;
            dasom++;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}