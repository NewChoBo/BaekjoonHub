import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            // 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이 구하기
            // 어떤 문자를 정확히 K개 포함하고, 문자열 첫 글자와 마지막 글자가 해당 문자로 가장 긴 연속 문자열의 길이 구하기
            // 만족하는게 없으면 -1 출력

            // 횟수 count는 기수 정렬 활용
            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;
            Map<Character, Queue<Integer>> charMap = new HashMap();

            char[] charArr = W.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                char c = charArr[i];
                if (!charMap.containsKey(c)) {
                    charMap.put(c, new ArrayDeque<>());
                }
                Queue<Integer> queue = charMap.get(c);
                queue.add(i);

                if (queue.size() == K) {
                    int start = queue.poll();
                    int length = i - start + 1;

                    if (length > maxLength) maxLength = length;
                    if (length < minLength) minLength = length;
                }
            }

            if (minLength == Integer.MAX_VALUE && maxLength == Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minLength + " " + maxLength);
            }
        }
    }
}