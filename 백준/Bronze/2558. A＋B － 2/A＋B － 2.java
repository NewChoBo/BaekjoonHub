import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        byte a = Byte.valueOf(br.readLine());
        byte b = Byte.valueOf(br.readLine());
        System.out.println(a + b);
    }
}