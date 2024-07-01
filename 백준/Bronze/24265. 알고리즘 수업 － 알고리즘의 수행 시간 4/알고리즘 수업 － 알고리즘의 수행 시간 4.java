import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long a = Integer.parseInt(br.readLine());
        System.out.println(a * (a - 1) / 2);
        System.out.println(2);
    }
}