import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int num = 0;
        for (int i = 0; i < 3; i++) {
            num++;
            String input = br.readLine();
            if (input.equals("Fizz") || input.equals("Buzz") || input.equals("FizzBuzz")) {
                continue;
            } else {
                num = Integer.parseInt(input);
            }
        }
        num++;
        StringBuilder sb = new StringBuilder();
        if (num % 3 == 0) sb.append("Fizz");
        if (num % 5 == 0) sb.append("Buzz");
        if (sb.length() == 0) System.out.println(num);
        else System.out.println(sb);
    }
}
