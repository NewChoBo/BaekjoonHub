import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int index1 = -1, index2 = -1;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("KBS1")) {
                index1 = i;
            } else if (input.equals("KBS2")) {
                index2 = i;
            }
        }
        if (index1 > index2) {
            index2++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < index1; i++) {
            sb.append(1);
        }
        for (int i = 0; i < index1; i++) {
            sb.append(4);
        }
        for (int i = 0; i < index2; i++) {
            sb.append(1);
        }
        for (int i = 0; i < index2 - 1; i++) {
            sb.append(4);
        }
        System.out.println(sb);
    }
}