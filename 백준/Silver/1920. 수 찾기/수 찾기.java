import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set = new HashSet<>();
        for(int num : A) {
            set.add(num);
        }
        StringBuilder sb = new StringBuilder();
        for(int num : B) {
            if(set.contains(num)) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.print(sb);
    }
}