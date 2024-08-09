import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int MAXIMUN = 10000;

    public static void main(String[] args) throws IOException {
        // 0이상 10000 미만의 십진수 저장 가능
        // D는 n을 2배로 바꿈. 값이 10000 이상이면 나눈 나머지
        // S는 n에서 1을 뺀 결과.0이라면 9999
        // L은 n의 각 자릿수를 왼편으로 회전시켜 레지스터에 저장 (2, 3, 4, 1)
        // R은 n의 각 자릿수를 오른편으로 회전시켜 레지스터에 저장 (4, 1, 2, 3)
        // 이게 골드 4????
        // 가능한 나열이 여러가지면 아무거나 출력


        // 주어진 서로 다른 두 정수 받고, A를 B로 바꾸는 최소한의 명령어 생성
        // T개의 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int A = input[0];
            int B = input[1];
            Counter[] counters = new Counter[MAXIMUN];
            for (int i = 0; i < counters.length; i++) {
                counters[i] = new Counter(i);
            }

            Queue<Counter> priorityQueue = new ArrayDeque<>();
            counters[A].visited = true;
            counters[A].prev = -1;
            priorityQueue.add(counters[A]);

            // A를 B로 바꾸는 최소 연산?
            // 이것도 priorityQueue를 사용하면 될 것으로 보인다.
            while (!priorityQueue.isEmpty()) {
                Counter current = priorityQueue.poll();
                int currentNumber = current.number;
                if (currentNumber == B) break;

                int d = D(currentNumber);
                checkAndAddQueue(priorityQueue, counters, currentNumber, d, 'D');
                int s = S(currentNumber);
                checkAndAddQueue(priorityQueue, counters, currentNumber, s, 'S');
                int l = L(currentNumber);
                checkAndAddQueue(priorityQueue, counters, currentNumber, l, 'L');
                int r = R(currentNumber);
                checkAndAddQueue(priorityQueue, counters, currentNumber, r, 'R');
            }

            StringBuilder sb = new StringBuilder();
            Counter counter = counters[B];
            while (true) {
                if (counter.prev == -1) break;
                sb.append(counter.move);
                counter = counters[counter.prev];
            }
            bw.write(sb.reverse().toString());
            bw.write("\n");
        }
        bw.flush();
    }

    public static void checkAndAddQueue(Queue<Counter> queue, Counter[] counters, int current, int next, char c) {
        if (!counters[next].visited) {
            counters[next].visited = true;
            counters[next].prev = current;
            counters[next].move = c;
            queue.add(counters[next]);
        }
    }

    public static int D(int num) {
        return (num * 2) % MAXIMUN;
    }

    public static int S(int num) {
        return (num == 0) ? 9999 : num - 1;
    }

    public static int L(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    public static int R(int num) {
        return (num % 10) * 1000 + num / 10;
    }

    static class Counter {
        int number;
        boolean visited = false;

        int prev;
        char move;

        Counter(int number) {
            this.number = number;
        }
    }
}