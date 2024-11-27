import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        final String loveKorUniv = "LoveisKoreaUniversity";
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            sb.append(loveKorUniv).append(' ');
        }
        System.out.print(sb);
    }
}