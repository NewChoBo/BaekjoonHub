import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    int current = 1000 - num;
    int cnt = 0;
    cnt += current / 500;
    current %= 500;
    cnt += current / 100;
    current %= 100;
    cnt += current / 50;
    current %= 50;
    cnt += current / 10;
    current %= 10;
    cnt += current / 5;
    current %= 5;
    cnt += current;

    System.out.println(cnt);

    br.close();
  }
}
