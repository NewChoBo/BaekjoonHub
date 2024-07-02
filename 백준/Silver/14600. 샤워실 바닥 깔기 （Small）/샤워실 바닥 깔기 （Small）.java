import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 샤워실 바닥 깔기
        // 샤워실의 구조는 정사각형이면서, 2의 제곱 수
        // 정사각형 타일 대신, 3칸짜리 ㄱ자 타일 활용

        int K = Integer.parseInt(br.readLine());    // 바닥의 한 변의 길이, 바닥의 크기는 2의 K제곱
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int y = input[0];   // 배수구의 위치 정보 제공
        int x = input[1];

        // 가장 왼쪽 아래가 (1,1), 오른쪽 위가 (2^K, 2^K)
        // 각 타일마다 고유한 번호를 매긴 타일의 배치도 출력
        // 배수구는 -1

        // 배치 방법 없으면 -1 출력

        // 필드 초기화
        int length = (int) Math.pow(2, K) + 1;
        int[][] field = new int[length][];
        for (int i = 1; i < field.length; i++) {
            field[i] = new int[length];
        }
        x = length - x;
//        y = length - y;
        field[x][y] = -1;

        // 일단 2 * 2, 4 * 4 까지만 고려하자
        if (K == 1) {
            for (int i = 1; i < length; i++) {
                int[] line = field[i];
                for (int j = 1; j < length; j++) {
                    if (line[j] == 0) {
                        line[j] = 1;
                    }
                }
            }
        } else {
            int cnt = 1;
            for (int i = 1; i < length; i++) {  // 1, 2, 3, 4 분면 구분없이 색칠
                int[] line = field[i];
                for (int j = 1; j < length; j++) {
                    int num = getQuadrant(i, j);
                    if (line[j] == 0) {
                        line[j] = num;
                    }
                }
            }
            // 배수구의 사분면 확인
            int point = getQuadrant(x, y);
            int[][] center = new int[][]{{2, 2}, {2, 3}, {3, 2}, {3, 3}};
            for (int[] arr : center) {
                if(getQuadrant(arr[0], arr[1]) != point) {
                    field[arr[0]][arr[1]] = 5;
                }
            }
        }
        for (int i = 1; i < length; i++) {
            int[] line = field[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < length; j++) {
                sb.append(line[j]).append(" ");
            }
            System.out.println(sb);
        }
    }

    static int getQuadrant(int x, int y) {
        if (x <= 2) {
            if (y <= 2) {
                return 1;
            } else return 2;
        } else {
            if (y <= 2) {
                return 3;
            } else {
                return 4;
            }
        }
    }
}