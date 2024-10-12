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
	}

	static void solve() {
		int start = 0;
		while (start <= M - (2 * N + 1)) {
			boolean isPattern = true;
			for (int i = 0; i < 2 * N + 1; i++) {
				if ((i % 2 == 0 && S[start + i] != 'I') || (i % 2 == 1 && S[start + i] != 'O')) {
					isPattern = false;
					break;
				}
			}

			if (isPattern) {
				cnt++;
				start += 2; // 이후 계속 IOI 패턴이 반복될 수 있으니 바로 다음 검사로 이동
			} else {
				start++; // 패턴이 깨졌으면 다음으로 이동
			}
		}

		System.out.println(cnt);
	}

	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine().toCharArray();
	}
}
