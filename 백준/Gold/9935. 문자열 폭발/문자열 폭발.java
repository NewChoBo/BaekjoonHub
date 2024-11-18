import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] input1 = br.readLine().toCharArray();
        String input2 = br.readLine();  // 같은 문자 2개 이상 포함하지 않는다


        StringBuilder sb = new StringBuilder();
        for (char c : input1) {
            sb.append(c);
            if (input2.length() <= sb.length() && sb.substring(sb.length() - input2.length()).equals(input2)) {
                sb.delete(sb.length() - input2.length(), sb.length());
            }
        }
        if ("".equals(sb.toString())) {
            System.out.print("FRULA");
        } else {
            System.out.print(sb);
        }
    }
}
