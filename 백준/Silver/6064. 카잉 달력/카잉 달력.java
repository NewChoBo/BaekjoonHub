import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long M = Integer.parseInt(st.nextToken());
			long N = Integer.parseInt(st.nextToken());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());

			// 공배수와 관련된 부분인듯?
			// M이 10이면 1~10, N이 12d이면 1~12 (x, y는 각각 M / N 으로 나눈 나머지 + 1 인듯?)
			// 만족하는 해가 없으면 -1 출력
			long max = getLcm(M, N);
			long result = -1;
			for (long i = x - 1; i < max; i += M) {
				if (i % N == y - 1) {
					result = i + 1;
					break;
				}
			}
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}

	// 유클리드 호재법
	public static long getGcd(long a, long b) {
		if (a < b) {    // a가 더 크도록 swap
			long temp = b;
			b = a;
			a = temp;
		}
		while (a % b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}

	public static long getLcm(long a, long b) {
		long gcd = getGcd(a, b);
		return (a / gcd) * b;
	}
}
