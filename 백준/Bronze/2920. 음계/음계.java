import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine().trim();
        if(input.equals("1 2 3 4 5 6 7 8")) {
            System.out.println("ascending");
            return;
        }
        if(input.equals("8 7 6 5 4 3 2 1")) {
            System.out.println("descending");
            return;
        }
        System.out.println("mixed");
    }
}