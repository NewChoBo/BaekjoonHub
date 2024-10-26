import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		while (T-- > 0) {
			char[] input = br.readLine().toCharArray();
			for (char c : input) {
				switch (c) {
					case 'A':
						sum += 4;
						break;
					case 'K':
						sum += 3;
						break;
					case 'Q':
						sum += 2;
						break;
					case 'J':
						sum += 1;
						break;
				}
			}
		}
		System.out.print(sum);
	}
}
