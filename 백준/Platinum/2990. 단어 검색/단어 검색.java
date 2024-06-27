import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Map<String, Integer> word = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<Character, WordCounter> parent = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] input = line.toCharArray();
            Map<Character, WordCounter> child = parent;
            int cnt = i + 1;
            for (char c : input) {
                if (!child.containsKey(c)) {
                    child.put(c, new WordCounter());
                }
                WordCounter wordCounter = child.get(c);
                wordCounter.counter++;
                cnt += wordCounter.counter;
                child = wordCounter.child;
            }
            word.put(line, cnt);
        }
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String input = br.readLine();
            if (word.get(input) != null) bw.write(word.get(input) + "\n");
            else {
                int cnt = 0;
                Map<Character, WordCounter> child = parent;
                for (char c : input.toCharArray()) {
                    if (!child.containsKey(c)) {
                        break;
                    }
                    WordCounter wordCounter = child.get(c);
                    cnt += wordCounter.counter;
                    child = wordCounter.child;
                }
                bw.write((cnt + N) + "\n");
            }
        }

        //BTREE를 사용하면 될 것 같은데
        // 다른 문자가 나올 때 까지 비교
        bw.flush();
    }
}

// 한번 한 연산을 다시 하지 않는것이 중요하다
// 새로 입력된 단어는 앞의 단어를 몇번 확인해야 도달할 수 있는가를 저장한다
class WordCounter {
    int counter = 0;
    Map<Character, WordCounter> child = new HashMap<>();
}