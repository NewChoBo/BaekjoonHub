import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[] knowsTruth; // 진실을 아는지 여부
    static List<Integer>[] parties; // 각 파티에 참여한 사람 목록
    static List<Integer>[] partyPeople; // 각 사람이 참여한 파티 목록
    static Set<Integer> truthKnower = new HashSet<>(); // 진실을 아는 사람들

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void solve() {
        // 진실을 아는 사람들로부터 시작해서 연결된 파티와 사람들에게 진실을 전파
        Queue<Integer> queue = new LinkedList<>(truthKnower);

        // BFS 탐색을 통해 진실을 전파
        while (!queue.isEmpty()) {
            int person = queue.poll();

            // 그 사람이 참석한 모든 파티 확인
            for (int partyNo : partyPeople[person]) {
                // 해당 파티의 다른 참석자들 확인
                for (int participant : parties[partyNo]) {
                    if (!knowsTruth[participant]) {
                        knowsTruth[participant] = true;
                        queue.add(participant); // 해당 참석자에게 진실이 전파되면, 그 사람도 추가
                    }
                }
            }
        }

        int count = 0;
        // 진실을 모르는 사람이 있는 파티만 카운트
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int participant : parties[i]) {
                if (knowsTruth[participant]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }
        System.out.println(count);
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        knowsTruth = new boolean[N + 1]; // 1부터 N까지 사용
        parties = new ArrayList[M]; // M개의 파티
        partyPeople = new ArrayList[N + 1]; // 각 사람이 참여한 파티 목록

        for (int i = 0; i <= N; i++) {
            partyPeople[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람 입력
        for (int i = 0; i < truthCnt; i++) {
            int person = Integer.parseInt(st.nextToken());
            knowsTruth[person] = true;
            truthKnower.add(person);
        }

        // 파티와 사람 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());

            // 파티에 참석한 사람들 입력
            for (int j = 0; j < partySize; j++) {
                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person); // 파티에 참여한 사람 목록 추가
                partyPeople[person].add(i); // 해당 사람이 참여한 파티 목록 추가
            }
        }
    }
}
