import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            integerArrayDeque.add(i);
        }

        Queue<Integer> queue = new ArrayDeque();
        boolean flag = false;
        while (!integerArrayDeque.isEmpty()) {
            int num = integerArrayDeque.poll();
            if (flag) integerArrayDeque.add(num);
            else queue.add(num);
            flag = !flag;
        }

        StringBuilder tempString = new StringBuilder();
        while (!queue.isEmpty()) {
            int num = queue.poll();
            tempString.append(num + " ");
        }
        bw.write(tempString.toString());
        bw.flush();
    }
}