import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] input1 = getInputArray(br.readLine());
        int N = input1[0];
        int M = input1[1];
        int[] line = getInputArray(br.readLine());

        int max = 0;
        int treeMaxHeight = Arrays.stream(line).max().getAsInt();

        while (treeMaxHeight >= max) {
            int index = (treeMaxHeight + max) / 2;
            long heightSum = getHeightSum(line, index);
            if (heightSum >= M) {
                max = index;
                if (treeMaxHeight == max) break;
                else if (treeMaxHeight == max + 1) {
                    long height = getHeightSum(line, max + 1);
                    if (height >= M) max++;
                    break;
                }
            } else {
                treeMaxHeight = index;
            }
        }
        System.out.println(max);
    }

    static long getHeightSum(int[] line, int index) {
        long heightSum = 0;
        for (int height : line) {
            if (height > index) {
                heightSum += height - index;
            }
        }
        return heightSum;
    }

    static int[] getInputArray(String line) {
        return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}