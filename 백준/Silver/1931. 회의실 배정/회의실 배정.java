import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// 1. 초기화
		// 회의 수
		int N = Integer.parseInt(br.readLine());    // 1 <= N <= 100,000

		// 회의 정보 (시작 ~ 끝 시간)
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			meetings[i] = new Meeting(br.readLine());
		}
		meetings = Arrays.stream(meetings).sorted((o1, o2) -> {
			if (o1.end != o2.end) {
				return o1.end - o2.end;
			}
			return o1.start - o2.start;
		}).toArray(Meeting[]::new);

		// 2. 회의 배치
		// end 시간이 가장 빠른것부터, start가 이전 end보다 크거나 같으면 가능
		int cnt = 0;
		int prevEnd = 0;
		for (Meeting meeting : meetings) {
			if (prevEnd <= meeting.start) {
				prevEnd = meeting.end;
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static class Meeting {
		int start, end;

		Meeting(String time) {
			StringTokenizer st = new StringTokenizer(time);
			this.start = Integer.parseInt(st.nextToken());
			this.end = Integer.parseInt(st.nextToken());
		}
	}
}
