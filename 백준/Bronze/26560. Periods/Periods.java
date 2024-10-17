import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String input = br.readLine();
            sb.append(input);
            if(!input.endsWith(".")) {
                sb.append('.');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }


}