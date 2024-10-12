import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N, M;
	static char[] S;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(cnt);
	}

	static void solve() {
		int length = 0;
		for (int i = 2; i < M; i++) {
			if (S[i] == 'I' && S[i - 1] == 'O' && S[i - 2] == 'I') {
				length = 3;
				try {
					while (S[i + 1] == 'O' && S[i + 2] == 'I') {
						length += 2;
						i += 2;
					}
				} catch (Exception e) {
				}
			} else {
				length = 0;
			}
			int res = ((length - 1) / 2) - N + 1;
			if (res > 0) {
				cnt += res;
			}
		}
	}

	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine().toCharArray();
	}
}
