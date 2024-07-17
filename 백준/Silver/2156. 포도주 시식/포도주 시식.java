import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /**
     * 6
     * 6    0
     * 10   6
     * 13   16
     * 9    23
     * 8    28
     * 1
     * ==> 33
     */

    public static void main(String[] args) throws IOException {
        // 분할 정복 알고리즘이 아닐까 싶음
        int n = Integer.parseInt(br.readLine());
        n += +3;
        int[] arr = new int[n];
        for (int i = 3; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        n++;
        int[] sum = new int[n];
        for (int i = 3; i < n; i++) {   //i에는 무조건 벽이 있다고 가정할 때 최댓값
            sum[i] = Math.max(arr[i - 1] + arr[i - 2] + sum[i - 3], arr[i - 1] + sum[i - 2]);
            sum[i] = Math.max(sum[i], sum[i - 1]);
        }


        System.out.println(sum[n - 1]);
    }
}