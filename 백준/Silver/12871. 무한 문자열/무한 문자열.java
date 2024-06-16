import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String t = br.readLine();

        StringBuilder realS = new StringBuilder();
        StringBuilder realT = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            realS.append(s);
            realT.append(t);
        }
        s = realS.substring(0, 100);
        t = realT.substring(0, 100);

        if (s.equals(t)) bw.write("1\n");
        else bw.write("0\n");

        bw.flush();
    }
}