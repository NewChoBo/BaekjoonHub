import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // 여학생 수
      int M = Integer.parseInt(st.nextToken()); // 남학생 수
      int K = Integer.parseInt(st.nextToken()); // 예외 인원

      // 2명의 여학생, 1명의 남학생 팀 결성 원칙
      // 최대 팀 수
      int res = 0;
      for (int i = 0; i <= 50; i++) {
        if (N < 2 * i || M < i) {
          break;
        }
        if ((N - 2 * i) + (M - i) < K) {
          break;
        }
        res = i;
      }
      System.out.println(res);
    }
  }
}
