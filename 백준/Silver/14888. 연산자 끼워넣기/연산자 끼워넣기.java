import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static long MAX = Long.MIN_VALUE, MIN = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // N개의 수로 이루어진 수열, 수와 수 사이에 끼울 수 있는 N-1개의 연산자
        // 연산자는 +,-,*,/
        // 연산자 우선순위 무시하고, 앞에서부터 진행. 나눗셈은 몫만 취함.
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        recursive(arr, operators, arr[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void recursive(int[] arr, int[] operators, long currentValue, int index) {
        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;
            operators[i]--;
            long newVal = currentValue;
            switch (i) {
                case 0:
                    newVal += arr[index];
                    break;
                case 1:
                    newVal -= arr[index];
                    break;
                case 2:
                    newVal *= arr[index];
                    break;
                case 3:
                    newVal /= arr[index];
                    break;
            }
            if (index < arr.length -1 ) {
                recursive(arr, operators, newVal, index + 1);
            } else {
                MAX = Math.max(MAX, newVal);
                MIN = Math.min(MIN, newVal);
            }
            operators[i]++;
        }
    }
}