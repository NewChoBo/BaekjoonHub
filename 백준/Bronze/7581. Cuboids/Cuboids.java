import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0 && d == 0) {
                break;
            }
            if (d == 0) d = a * b * c;
            else if (a == 0) {
                a = d / (b * c);
            } else if (b == 0) {
                b = d / (a * c);
            } else if (c == 0) {
                c = d / (a * b);
            }

            sb.append(a).append(' ').append(b).append(' ').append(c).append(' ').append(d).append('\n');
        }
        System.out.print(sb);
    }
}