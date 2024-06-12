import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) stack.pop();
            else stack.push(num);
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}