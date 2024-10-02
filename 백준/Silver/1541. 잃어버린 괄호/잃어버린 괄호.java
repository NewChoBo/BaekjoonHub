import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int[] numbers = Arrays.stream(input.split("[-+]")).mapToInt(Integer::parseInt).toArray();

        int cnt = 1;
        boolean flag = false;
        for (char c : input.toCharArray()) {
            switch (c) {
                case '+':
                    cnt++;
                    break;
                case '-':
                    flag = true;
                    break;
                default:
                    break;
            }
            if (flag) break;
        }
        if (!flag) {
            cnt = numbers.length;
        }
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += numbers[i];
        }
        for (int i = cnt; i < numbers.length; i++) {
            sum -= numbers[i];
        }
        System.out.println(sum);
    }
}