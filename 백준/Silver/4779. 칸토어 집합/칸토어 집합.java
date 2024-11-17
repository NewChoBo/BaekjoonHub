import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = br.readLine()) != null && !line.isEmpty()) {
      int size = (int) Math.pow(3, Integer.parseInt(line));
      char[] arr = new char[size];
      Arrays.fill(arr, '-');
      recursive(arr, 0, size);
      sb.append(String.valueOf(arr)).append("\n");
    }
    System.out.print(sb);
  }

  static void recursive(char[] arr, int start, int end) {
    if (end - start < 3) {
      return;
    }
    int size = (end - start) / 3;
    Arrays.fill(arr, start + size, start + size * 2, ' ');
    recursive(arr, start, start + size);
    recursive(arr, start + size * 2, end);
  }
}