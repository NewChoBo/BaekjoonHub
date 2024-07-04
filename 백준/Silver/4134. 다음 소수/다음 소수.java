import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 정수 n이 주어질 때, n보다 크거나 같은 소수 중 가장 작은 소수를 찾는 프로그램
        long T = Long.parseLong(br.readLine());    // test case T
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            long n = Long.parseLong(br.readLine());    // 입력
            long num = 2;
            if (n > 2) {
                num = getNum(n);
            }
            sb.append(num).append("\n");
        }
        System.out.print(sb.toString());
    }

    static long getNum(long n) {
        while (true) {  // n 이상의 수 중에서, 가장 작은 소수를 한 줄에 하나씩 출력
            // 소수인지 확인
            long sqrt = (long) Math.sqrt(n);
            boolean flag = true;
            for (long i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return n;
            }
            n++;
        }
    }
}