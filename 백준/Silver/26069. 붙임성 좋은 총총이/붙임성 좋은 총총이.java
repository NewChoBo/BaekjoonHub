import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        HashSet<String> knowsDance = new HashSet<>();
        knowsDance.add("ChongChong");
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (knowsDance.contains(a)) {
                knowsDance.add(b);
            } else if (knowsDance.contains(b)) {
                knowsDance.add(a);
            }
        }
        System.out.println(knowsDance.size());
    }
}