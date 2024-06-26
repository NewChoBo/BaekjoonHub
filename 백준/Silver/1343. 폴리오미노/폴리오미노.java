import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        String[] words = line.split("\\.");
        Queue<String> queue = new ArrayDeque();

        for (String word : words) {
            if (word.length() % 2 != 0) {
                System.out.println(-1);
                return;
            }
            queue.add(word);
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                sb.append('.');
                continue;
            }
            String word = queue.poll();
            int aCnt = word.length() / 4;
            for (int j = 0; j < aCnt; j++) {
                sb.append("AAAA");
            }
            if (word.length() % 4 != 0) {
                sb.append("BB");
            }
            i += word.length() - 1;
        }
        System.out.println(sb.toString());
    }
}