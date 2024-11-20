import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    String str;
    StringBuilder sb = new StringBuilder();
    while (!(str = br.readLine()).equals("0")) {
      boolean digitalRoot = false;
      int sum = 0;
      while (!digitalRoot) {
        for (int i = 0; i < str.length(); i++) {
          sum += str.charAt(i) - '0';
        }
        if (sum < 10) {
          digitalRoot = true;
          sb.append(sum).append('\n');
        } else {
          str = String.valueOf(sum);
          sum = 0;
        }
      }
    }
    System.out.print(sb);
  }
}