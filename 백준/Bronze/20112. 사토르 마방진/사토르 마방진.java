import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		char[][] words = new char[N][];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine().toCharArray();
		}
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (words[i][j] != words[j][i]) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
		}
		System.out.println(flag ? "YES" : "NO");
	}
}
