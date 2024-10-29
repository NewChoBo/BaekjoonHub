import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i = 1;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) num--;
            arrayList.add(new int[]{i, num});
            i++;
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (!arrayList.isEmpty()) {
            index = (index % arrayList.size() + arrayList.size()) % arrayList.size();
            int[] current = arrayList.remove(index);
            index += current[1];
            sb.append(current[0]).append(' ');
        }
        System.out.print(sb);
    }
}
