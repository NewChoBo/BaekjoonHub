import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Set<Integer>[] users = init();
        int result = getKevinMinResult(users);
        System.out.println(result);
    }

    private static int getKevinMinResult(Set<Integer>[] users) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < users.length; i++) {
            int[] counter = new int[users.length];
            Arrays.fill(counter, Integer.MAX_VALUE - 1);
            Stack<Integer> stack = new Stack<>();
            counter[i] = 0;
            stack.add(i);

            while (!stack.isEmpty()) {
                int userNo = stack.pop();
                Set<Integer> user = users[userNo];
                for (int friend : user) {
                    if (counter[friend] <= counter[userNo] + 1) continue;
                    counter[friend] = counter[userNo] + 1;
                    stack.add(friend);
                }
            }


            // 최소값 갱신 시 값 변경
            int sum = 0;
            for (int j = 1; j < counter.length; j++) {
                sum += counter[j];
            }
            if (sum < min) {
                min = sum;
                index = i;
            }
        }
        return index;
    }

    private static Set<Integer>[] init() throws IOException {
        StringTokenizer input1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input1.nextToken());
        int M = Integer.parseInt(input1.nextToken());
        Set<Integer>[] users = new HashSet[N + 1];
        for (int i = 0; i < N + 1; i++) {
            users[i] = new HashSet<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer input2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(input2.nextToken());
            int b = Integer.parseInt(input2.nextToken());
            users[a].add(b);
            users[b].add(a);
        }
        return users;
    }
}