import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        /*
         유성
         유성 사진을 문자 배열로 단순화하여 표기
         X는 유성의 일부를, #는 땅의 일부를, 나머지 공기는 . 으로 이뤄진다
         모든 유성 조각은 연결되어있다. 땅 또한 서로 연결되어있다.
         사진에서 유성은 땅보다 위에 있다 (땅과 유성 사이에 한 줄 이상의 공기가 있다)
         사진의 맨 밑줄은 모두 땅이다
         유성은 수직 낙하한다. 땅으로 떨어졌을 때 원형을 유지한다고 할 때, 유성 떨어진 후의 사진을 복구하여라
         */
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int R = input1[0];  // 세로
        int S = input1[1];  // 가로

        //이미지 입력
        char[][] image = new char[R][];
        for (int i = R - 1; i >= 0; i--) {
            image[i] = br.readLine().toCharArray();
        }

        // 2중 for 문을 순회할 때마다 9백만회의 연산 발생
        // 땅과 유성 사이의 거리를 구해야 함
        int airSize = Integer.MAX_VALUE;
        Queue<Integer> meteorHeightQueue = new ArrayDeque<>();
        for (int i = 0; i < S; i++) {
            int earthHeight = 0;
            int meteorHeight = -1;

            for (int j = 0; j < R; j++) {
                char c = image[j][i];

                if (c == '#') {
                    earthHeight = j;
                } else if (c == 'X') {
                    meteorHeight = j;
                    break;
                }
            }
            meteorHeightQueue.offer(meteorHeight);
            if (meteorHeight != -1 && meteorHeight - earthHeight < airSize) airSize = meteorHeight - earthHeight;
        }
        airSize--;

        // airSize: 내려와야 하는 유성의 칸 수
        for (int i = 0; i < S; i++) {
            int meteorHeight = meteorHeightQueue.poll();
            if (meteorHeight == -1) continue; // 여기는 유성이 없다
            for (int j = meteorHeight - airSize; j < R; j++) {
                char c = '.';
                if (j + airSize < R) c = image[j + airSize][i];
                image[j][i] = c;
            }
        }

        // 출력
        for (int i = image.length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            char[] line = image[i];
            for (char c : line) {
                sb.append(c);
            }
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }
}