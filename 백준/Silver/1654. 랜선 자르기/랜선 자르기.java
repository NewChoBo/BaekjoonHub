import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    // https://www.acmicpc.net/problem/30802

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 길이는 int 최댓값
        int K = input[0];   // 갖고있는 개수 (10000 이하)
        int N = input[1];   // 필요한 개수 (100만 이하)

        List<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            integerArrayList.add(Integer.parseInt(br.readLine()));
        }

        // 퀵소트 하듯이 검색 범위를 좁혀나가볼까?
        long max = (long)Integer.MAX_VALUE + 1;
        long min = 1;
        while (true) {
            long cnt = 0;
            long compareValue = (max + min) / 2;
            for (int num : integerArrayList) {
                cnt += num / compareValue;
            }
            if (cnt < N) max = compareValue;
            else min = compareValue;
//            System.out.println("min: " + min + ", max: " + max);
//            System.out.println("compareValue: " + compareValue);
            if (min >= max -1) break;
        }
        System.out.println(min);
    }
}