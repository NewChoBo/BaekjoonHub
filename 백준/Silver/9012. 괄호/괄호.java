import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] input = br.readLine().toCharArray();
            int cnt = 0;
            for (char c : input) {
                if (c == '(') cnt++;
                else if (c == ')')
                    cnt--;
                if (cnt < 0) break;
            }
            if (cnt == 0) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
}