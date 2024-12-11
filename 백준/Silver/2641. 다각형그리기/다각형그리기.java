import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 전부다 set에 넣으면 된다.
    // https://www.acmicpc.net/problem/2641
    static Set<String> stringSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String originalStr = br.readLine();
        addStringsToSet(originalStr);
        addStringsToSet(getReverseString(originalStr));

        int T = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            if (stringSet.contains(input)) {
                cnt++;
                sb.append(input).append('\n');
            }
        }
        System.out.println(cnt);
        System.out.print(sb);
    }

    static void addStringsToSet(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < stringBuilder.length(); i += 2) {
            stringBuilder.append(' ').append(stringBuilder.substring(0, 1));
            stringBuilder.delete(0, 2);
            stringSet.add(stringBuilder.toString());
        }
    }

    static String getReverseString(String originalStr) {
        StringBuilder sb = new StringBuilder();
        for (char c : originalStr.toCharArray()) {
            if (c == ' ') sb.append(' ');
            else {
                int tmp = c - '0';
                tmp = (tmp + 2) % 4;
                if (tmp == 0) tmp = 4;
                sb.append(tmp);
            }
        }
        return sb.reverse().toString();
    }
}