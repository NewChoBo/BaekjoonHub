import java.io.*;

public class Main {
    static final int MAX = 1000000;
    static boolean[] isNotPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sieveOfEratosthenes();

        int T = Integer.parseInt(br.readLine()); // 테스트의 개수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 2보다 큰 짝수

            if (N % 2 == 0 && N > 2) { // 짝수이고 2보다 큰 경우에만 처리
                int partitionCount = countPrimePartitions(N);
                bw.write(partitionCount + "\n");
            } else {
                bw.write("0\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // 에라토스테네스의 체를 사용하여 소수를 미리 구하는 메서드
    static void sieveOfEratosthenes() {
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    // 소수 쌍의 개수를 구하는 메서드
    static int countPrimePartitions(int N) {
        int count = 0;
        for (int i = 2; i <= N / 2; i++) {
            if (!isNotPrime[i] && !isNotPrime[N - i]) {
                count++;
            }
        }
        return count;
    }
}
