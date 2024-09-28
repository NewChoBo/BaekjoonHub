import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input;
        StringBuilder sb = new StringBuilder();
        while (!"#".equals(input = br.readLine())) {
            int cnt = 0;
            for (char c : input.toCharArray()) {
                switch (c) {
                    case 'a':
                    case 'A':
                    case 'e':
                    case 'E':
                    case 'i':
                    case 'I':
                    case 'o':
                    case 'O':
                    case 'u':
                    case 'U':
                        cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
