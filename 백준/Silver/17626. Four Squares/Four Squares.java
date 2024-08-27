import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 4);
        List<Integer>[] collector = new ArrayList[5];
        for (int i = 1; i < 5; i++) {
            collector[i] = new ArrayList<>();
        }

        for (int i = 1; i < arr.length; i++) {  // 제곱근을 가진 수 들은 1초 초기화
            int val = (int) Math.pow(i, 2);
            if (val > n) break;
            collector[1].add(val);
            arr[val] = 1;
        }

        // n 제곱근 이상의 수까지는 필요 없음
        for (int num1 : collector[1]) {
            for (int num2 : collector[1]) {
                int sum = num1 + num2;
                if (sum <= n && arr[sum] > 2) {
                    collector[2].add(sum);
                    arr[sum] = 2;
                }
            }
        }

        for (int num1 : collector[1]) {
            for (int num2 : collector[2]) {
                int sum = num1 + num2;
                if (sum <= n && arr[sum] > 3) {
                    arr[sum] = 3;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(' ');
        }
//        System.out.println(sb);
        System.out.println(arr[n]);
    }
}