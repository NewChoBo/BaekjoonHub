import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int B = Integer.parseInt(st2.nextToken());
    int C = Integer.parseInt(st2.nextToken());

    long sum = 0; // long 사용 (큰 값 처리 가능)

    for (int i = 0; i < N; i++) {
      int humans = Integer.parseInt(st.nextToken());

      // 총감독관 처리
      sum++;
      humans -= B;

      // 부감독관 처리
      if (humans > 0) {
        sum += (humans + C - 1) / C; // 올림 처리
      }
    }

    System.out.println(sum);
  }
}
