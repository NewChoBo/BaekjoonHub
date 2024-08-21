import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            String action = input[0];
            int num = 0;
            if (input.length == 2) num = Integer.parseInt(input[1]);

            switch (action) {
                case "push":
                    deque.offer(num);
                    break;
                case "pop":
                    if(deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.poll());
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(deque.size());
                    sb.append('\n');
                    break;
                case "empty":
                    if(deque.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append('\n');
                    break;
                case "front":
                    if(deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.peekFirst());
                    sb.append('\n');
                    break;
                case "back":
                    if(deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.peekLast());
                    sb.append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}