import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		List<Integer> list = Arrays.stream(br.readLine().split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		list = list.stream().sorted().collect(Collectors.toList());

		if (list.get(2) >= list.get(0) + list.get(1)) {
			list.set(2, list.get(0) + list.get(1) - 1);
		}
		bw.write(String.valueOf(list.get(0) + list.get(1) + list.get(2)));
		bw.flush();
	}
}
