import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			arr[i] = num;
		}
		arr = Arrays.stream(arr).sorted().toArray();

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - (arr[i] + arr[j]) == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i || k == j)
							continue;
						System.out.println(arr[k]);
					}
					return;
				}
			}
		}
	}
}
