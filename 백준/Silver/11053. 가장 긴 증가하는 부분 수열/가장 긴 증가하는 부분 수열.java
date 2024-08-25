import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// 결국은 모든 경우의 수를 탐색해야 할 것으로 보임.
		// 다만, 중복 연산을 최소화 하는 방향으로 진행하면 될 것.
		// 현 지점까지 최댓값 (숫자)
		// 현 지점까지 개수 최댓값
		int[] cnt = new int[N];
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (A[j] < A[i] && cnt[j] > max) {
					max = cnt[j];
				}
			}
			cnt[i] = max + 1;
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (max < cnt[i]) {
				max = cnt[i];
			}
		}
		System.out.println(max);
	}
}
