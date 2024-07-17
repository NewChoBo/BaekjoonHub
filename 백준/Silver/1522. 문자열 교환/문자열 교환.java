import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // abababababababa: 3
        char[] chars = br.readLine().toCharArray();
        int aTotal = 0;
        for (char c : chars) {
            if (c == 'a') aTotal++;
        }

        int start = 0;
        int aCount = 0;
        for (int i = 0; i < aTotal; i++) {
            if (chars[i] == 'a') aCount++;
        }
        int max = aCount;
        for (int i = start; i < chars.length; i++) {
            int end = (i + aTotal) % chars.length;
            if (chars[i] == 'a') aCount--;
            if (chars[end] == 'a') {
                aCount++;
                if (aCount > max) max = aCount;
            }
        }

        System.out.println(aTotal - max);
    }
}