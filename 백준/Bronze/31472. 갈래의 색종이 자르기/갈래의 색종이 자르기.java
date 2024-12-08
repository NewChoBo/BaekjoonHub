import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());  // 색종이 절반의 넓이
		double size = Math.sqrt(n * 2);
		int res = 4 * (int)size;
		System.out.println(res);
	}
}