import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();

		while (n > 0) {
			String[] arr = br.readLine().split(" ");
			switch (arr[1]) {
				case "enter":
					set.add(arr[0]);
					break;
				case "leave":
					set.remove(arr[0]);
					break;
			}
			n--;
		}
		List<String> data = set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		for (int i = 0; i < data.size(); i++) {
			bw.write(data.get(i));
			if (i != data.size() - 1) {
				bw.write("\n");
			}
		}

		bw.flush();
	}
}
