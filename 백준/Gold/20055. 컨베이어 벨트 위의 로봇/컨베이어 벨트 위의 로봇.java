import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input1[0];  // 벨트 길이
        int K = input1[1];  // 내구도 0이 K개 이상이면 과정 종료

        int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();   // 벨트 내구도

        List<Belt> beltList = new ArrayList<>();
        int broken = 0;
        for (int num : input2) {
            beltList.add(new Belt(num));
            if (num == 0) broken++;
        }

        int cnt = 1;    // 진행 횟수이자 인덱스

        while (broken < K) {
            int firstPosition = (2 * N - (cnt % (2 * N))) % (2 * N);
            Belt firstBelt = beltList.get(firstPosition);
            Belt lastBelt = beltList.get((firstPosition + N - 1) % (2 * N));

            lastBelt.robot = false;
            for (int i = N - 1; i >= 0; i--) {
                int currentPosition = (firstPosition + i) % (2 * N);
                Belt currentBelt = beltList.get(currentPosition);
                if (currentBelt.robot) {
                    int nextPosition = (currentPosition + 1) % (2 * N);
                    Belt nextBelt = beltList.get(nextPosition);
                    if (!nextBelt.robot && nextBelt.durability > 0) {
                        currentBelt.robot = false;
                        nextBelt.robot = true;
                        nextBelt.durability--;
                        if (nextBelt.durability == 0) {
                            broken++;
                        }
                    }
                }
            }
            lastBelt.robot = false;

            if (firstBelt.durability > 0) {
                firstBelt.robot = true;
                firstBelt.durability--;
                if (firstBelt.durability == 0) {
                    broken++;
                }
            }
            cnt++;
        }
        System.out.println(cnt - 1);
    }

    static class Belt {
        int durability;
        boolean robot = false;

        Belt(int durability) {
            this.durability = durability;
        }
    }
}