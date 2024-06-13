import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        char[] N = br.readLine().toCharArray();
        int[] num = new int[10];
        for (char a : N) {
            int number = Integer.parseInt(String.valueOf(a));
            num[number]++;
        }
        num[6] += num[9];
        num[6]++;
        num[6] /= 2;
        int max = 0;
        for (int i = 0; i < 9; i++) {
            if(max < num[i]) {
                max = num[i];
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}