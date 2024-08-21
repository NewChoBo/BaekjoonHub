import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input;
        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals("0")) {
            char[] charArr = input.toCharArray();
            int size = charArr.length;
            boolean flag = true;
            for (int i = 0; i < size / 2; i++) {
                if (charArr[i] != charArr[size - i - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) sb.append("yes");
            else sb.append("no");
            sb.append('\n');
        }
        System.out.print(sb);
    }
}