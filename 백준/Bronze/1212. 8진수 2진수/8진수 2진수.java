import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    char[] chars = br.readLine().toCharArray();
    StringBuilder sb = new StringBuilder();
    for (char c : chars) {
      int b = c - '0';
      switch (b) {
        case 0:
          sb.append("000");
          break;
        case 1:
          sb.append("001");
          break;
        case 2:
          sb.append("010");
          break;
        case 3:
          sb.append("011");
          break;
        case 4:
          sb.append("100");
          break;
        case 5:
          sb.append("101");
          break;
        case 6:
          sb.append("110");
          break;
        case 7:
          sb.append("111");
          break;
      }
    }
    String result = sb.toString();
    while (result.startsWith("0")) {
      result = result.substring(1);
    }
    System.out.print(result.isEmpty() ? "0" : result);
  }
}