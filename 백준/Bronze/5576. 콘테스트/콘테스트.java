import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Comparator.comparingInt(o -> -o));

        for (int i = 0; i < 10; i++) {
            priorityQueue1.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < 10; i++) {
            priorityQueue2.add(Integer.parseInt(br.readLine()));
        }
        int sum1 = priorityQueue1.poll() + priorityQueue1.poll() + priorityQueue1.poll();
        int sum2 = priorityQueue2.poll() + priorityQueue2.poll() + priorityQueue2.poll();
        System.out.println(sum1 + " " + sum2);
    }
}