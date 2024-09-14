import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		int[][] sum = new int[2][];
		sum[0] = new int[num];
		sum[1] = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		sum[0][0] = arr[0];
		sum[1][0] = arr[0];
		if (num > 1) {
			sum[0][1] = arr[1];
			sum[1][1] = arr[0] + arr[1];
		}
		for (int i = 2; i < num; i++) {
			sum[0][i] = Math.max(sum[0][i - 2] + arr[i], sum[1][i - 2] + arr[i]);
			sum[1][i] = sum[0][i - 1] + arr[i];
		}
		System.out.println(Math.max(sum[0][num - 1], sum[1][num - 1]));
	}
}
