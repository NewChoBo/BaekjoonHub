import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        // ax + by = c
        // dx + ey = f
        /*
         a*d x + b*d y = c*d
         d*a x + e*a y = f*a

         (b*d)-(e*a) y = (c*d) - (f*a)
         y = (c*d - f*a) / (b*d)-(e*a)
         */

        // dby - aey = dc - af
        // y = (dc - af) / db

        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);
        int d = list.get(3);
        int e = list.get(4);
        int f = list.get(5);

        int denominator = a * e - b * d;

        int x = (c * e - b * f) / denominator;
        int y = (a * f - c * d) / denominator;

        bw.write(x + " " + y);

        bw.flush();
        br.close();
        bw.close();
    }
}