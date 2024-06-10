import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(br.readLine());
			int cnt = 0;

			for (int j = 0; j * 3 <= value; j++) {
				cnt += (value - j * 3) / 2 + 1;
			}

			bw.write(String.valueOf(cnt));
			if (i != n - 1)
				bw.write("\n");
		}
		bw.flush();
	}
}
