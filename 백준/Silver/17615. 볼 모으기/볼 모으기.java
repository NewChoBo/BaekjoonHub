import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();      // 볼의 색상은 R or B, 두 가지 뿐, 둘 중 하나만 제공될 수도 있음

        // 왼쪽을 빨강으로 오른쪽을 파랑으로 할 수도 있고, 그 반대도 가능함.
        // 왼쪽을 빨강으로 하는 경우
        // 빨강이 이동 or 파랑이 이동
        // 빨강이 이동하는 경우, 라인을 처음부터 끝까지 이동하면서 빨강 자신과 연속되지 않은 빨강의 개수를 카운트
        // 파랑이 이동하는 경우, 마지막 빨강의 위치 전까지의 파랑 개수 카운트

        boolean startWithRedFlag = line[0] == 'R';
        int redMoveCnt = 0;
        int blueMoveCnt = 0;
        for (char c : line) {
            switch (c) {
                case 'R':
                    if (!startWithRedFlag) {
                        redMoveCnt++;
                    }
                    break;
                case 'B':
                    startWithRedFlag = false;
                    break;
            }
        }
        boolean foundLastRedFlag = false;
        for (int i = line.length - 1; i >= 0; i--) {
            char c = line[i];
            switch (c) {
                case 'R':
                    foundLastRedFlag = true;
                    break;
                case 'B':
                    if (foundLastRedFlag) {
                        blueMoveCnt++;
                    }
                    break;
            }
        }

        // 파랑을 왼쪽으로
        boolean startWithBlueFlag = line[0] == 'B';
        int redMoveCnt2 = 0;
        int blueMoveCnt2 = 0;
        for (char c : line) {
            switch (c) {
                case 'B':
                    if (!startWithBlueFlag) {
                        redMoveCnt2++;
                    }
                    break;
                case 'R':
                    startWithBlueFlag = false;
                    break;
            }
        }
        boolean foundLastBlueFlag = false;
        for (int i = line.length - 1; i >= 0; i--) {
            char c = line[i];
            switch (c) {
                case 'B':
                    foundLastBlueFlag = true;
                    break;
                case 'R':
                    if (foundLastBlueFlag) {
                        blueMoveCnt2++;
                    }
                    break;
            }
        }
        int min = Integer.MAX_VALUE;
        if(min > redMoveCnt) min = redMoveCnt;
        if(min > redMoveCnt2) min = redMoveCnt2;
        if(min > blueMoveCnt) min = blueMoveCnt;
        if(min > blueMoveCnt2) min = blueMoveCnt2;
        bw.write(String.valueOf(min));
        bw.flush();
    }
}