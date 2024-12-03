import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {   // K개의 로프 사용 시 w/k 만큼의 중량 발생
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.comparingInt(o -> -o));
        for (int i = 0; i < N; i++) {
            cnt++;
            int sum = cnt * list.get(i);
            if (max < sum) {
                max = sum;
            }
        }
        System.out.print(max);
    }
}