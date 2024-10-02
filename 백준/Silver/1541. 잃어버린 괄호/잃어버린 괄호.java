import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int cnt = 1;
        boolean flag = false;
        for (char c : input.toCharArray()) {
            if (c == '+') {
                cnt++;
            } else if (c == '-') {
                flag = true;
                break;
            }
        }
        int[] numbers = Arrays.stream(input.split("[-+]")).mapToInt(Integer::parseInt).toArray();
        if (!flag) {
            cnt = numbers.length;
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i < cnt) {
                sum += numbers[i];
            } else {
                sum -= numbers[i];
            }
        }
        System.out.println(sum);
    }
}