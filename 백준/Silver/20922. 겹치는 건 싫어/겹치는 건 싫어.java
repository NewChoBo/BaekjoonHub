import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input[0];
		int K = input[1];    // K개까지는 ㄱㅊ
		int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// 슬라이딩 윈도우... 생각도 못했다
		int start = 0;
		int end = 0;
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : inputArr) {    // end 1씩 올리는 과정
			if (!map.containsKey(num)) {    // 기존에 없던거면 Map 생성
				map.put(num, 0);
			}
			map.put(num, map.get(num) + 1);

			// end 증가
			end++;

			// 개수를 초과한 경우, start 위치를 초과하지 않을 때 까지 +1
			while (map.get(num) > K) {
				int value = inputArr[start];
				map.put(value, map.get(value) - 1);
				start++;
			}

			if (end - start > max) {
				max = end - start;
			}
		}
		bw.write(String.valueOf(max));
		bw.flush();
	}
}
