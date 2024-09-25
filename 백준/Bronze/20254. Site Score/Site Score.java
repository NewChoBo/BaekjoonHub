import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int Ur = input[0];
        int Tr = input[1];
        int Uo = input[2];
        int To = input[3];

        System.out.println(56 * Ur + 24 * Tr + 14 * Uo + 6 * To);
    }
}