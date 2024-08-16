import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        int[][] tree = new int[size][];
        int[][] sum = new int[size][];
        for (int i = 0; i < size; i++) {
            tree[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sum[i] = new int[i + 1];
        }

        sum[0][0] = tree[0][0];
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < tree[i].length; j++) {
                int num = 0;
                if (j < tree[i].length - 1) {
                    num = sum[i - 1][j];
                }
                if (j != 0 && num < sum[i - 1][j - 1]) {
                    num = sum[i - 1][j - 1];
                }
                sum[i][j] = tree[i][j] + num;
            }
        }
        int max = 0;
        for(int i=0; i<sum[size-1].length; i++) {
            if(sum[size-1][i] > max) max = sum[size-1][i];
        }
        System.out.println(max);
    }
}