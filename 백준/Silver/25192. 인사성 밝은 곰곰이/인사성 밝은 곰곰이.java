import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = null;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if ("ENTER".equals(input)) {
                set = new HashSet<>();
            } else {
                if (!set.contains(input)) {
                    set.add(input);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}