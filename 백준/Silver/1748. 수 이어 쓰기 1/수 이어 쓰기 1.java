import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String N = br.readLine();
        int length = N.length();

        int cnt = 0;
        int current = 0;
        for (int i = 0; i < length; i++) {
            StringBuilder string1 = new StringBuilder();
            string1.append("0");
            string1.append("9".repeat(i));
            int newNum = Integer.parseInt(string1.toString());
            cnt += (newNum - current) * i;
            current = newNum;
        }
        cnt += (Integer.parseInt(N) - current) * length;
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}