import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static final int[] FIRST = {500, 300, 300, 200, 200, 200, 50, 50, 50, 50, 30, 30, 30, 30, 30, 10, 10, 10, 10,
			10, 10};
	private static final int[] SECOND = {512, 256, 256, 128, 128, 128, 128, 64, 64, 64, 64, 64, 64, 64, 64,
			32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int money = 0;
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			if (a > 0 && a <= 21)
				money += FIRST[a - 1];
			if (b > 0 && b <= 31)
				money += SECOND[b - 1];

			bw.write(money * 10000 + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}