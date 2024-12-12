import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<char[]> charArrList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            charArrList.add(br.readLine().toCharArray());
        }
        charArrList.sort((o1, o2) -> {
            if (o1.length != o2.length) {
                return o1.length - o2.length;
            }
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < o1.length; i++) {
                if ('0' <= o1[i] && o1[i] <= '9') {
                    sum1 += o1[i] - '0';
                }
                if ('0' <= o2[i] && o2[i] <= '9') {
                    sum2 += o2[i] - '0';
                }
            }
            if (sum1 != sum2) return sum1 - sum2;
            for (int i = 0; i < o1.length; i++) {
                if (o1[i] != o2[i]) {
                    return o1[i] - o2[i];
                }
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArrList.size(); i++) {
            sb.append(String.valueOf(charArrList.get(i))).append('\n');
        }
        System.out.print(sb);
    }
}