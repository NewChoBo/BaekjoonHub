import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 웜 바이러스는 네트워크 통해 전파
        // 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터의 수
        int computerSize = Integer.parseInt(br.readLine());
        int linkSize = Integer.parseInt(br.readLine());
        Computer[] computers = new Computer[computerSize + 1];
        for (int i = 0; i < computerSize + 1; i++) {
            computers[i] = new Computer();
        }
        for (int i = 0; i < linkSize; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            computers[a].integerSet.add(b);
            computers[b].integerSet.add(a);
        }

        Queue<Integer> integerQueue = new ArrayDeque<>();
        integerQueue.add(1);
        computers[1].visited = true;

        int cnt = 0;
        while (!integerQueue.isEmpty()) {
            int num = integerQueue.poll();
            Computer computer = computers[num];
            for (int current : computer.integerSet) {
                Computer currentComputer = computers[current];
                if (!currentComputer.visited) {
                    integerQueue.add(current);
                    currentComputer.visited = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static class Computer {
        boolean visited = false;
        Set<Integer> integerSet = new HashSet<>();
    }
}
