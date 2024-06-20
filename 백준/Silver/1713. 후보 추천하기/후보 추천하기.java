import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 회장 후보는 일정 기간동안 전체 학생의 추천에 의해 정해진 수만큼 선정
        // 학생 사진 게시할 수 있는 사진들 후보 수만큼 생성
        // 추천받은 학생의 사진, 사진틀에 게시하고 추천받은 횟수 표시
        //1. 모든 사진틀은 빈 상태로 시작
        //2. 특정 학생 추천 시 추천받은 학생 사진틀에 게시
        //3. 빈 사진틀이 없으면 추천받은 횟수 적은 학생 사진 삭제 후 추천받은 사진 게시, 최소 추천 수가 겹치면 오래된 사진 삭제
        //4. 현재 사진 게시된 학생 다른 학생 추천받으면 추천받은 횟수 증가
        //5. 사진틀 게시된 사진 삭제 시 해당 학생 추천받은 수 0

        int N = Integer.parseInt(br.readLine());    // 사진틀 수
        int vote = Integer.parseInt(br.readLine());    // 전체 학생 총 추천 횟수
        int[] voteMap = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();      // 추천항목
        int seq = 0;

        Map<Integer, Album> voteCounter = new HashMap<>();
        for (int i : voteMap) {
            if (voteCounter.get(i) == null) {   //기존 엘범에 없는 경우
                if (voteCounter.size() >= N) {      // 엘범 공간이 꽉참
                    int index = 0;
                    int min = Integer.MAX_VALUE;
                    int newSeq = Integer.MAX_VALUE;
                    for (int j : voteCounter.keySet()) {
                        if (voteCounter.get(j).cnt < min || voteCounter.get(j).cnt == min && voteCounter.get(j).seq < newSeq) {
                            index = j;
                            min = voteCounter.get(j).cnt;
                            newSeq = voteCounter.get(j).seq;
                        }
                    }
                    voteCounter.remove(index);
                }
                seq++;
                voteCounter.put(i, new Album(seq));
            } else {    // 기존 엘범에 있는 경우
                voteCounter.get(i).cnt++;
            }
        }

        Queue<Integer> integerQueue = new PriorityQueue<>();
        for (int i : voteCounter.keySet()) {
            integerQueue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!integerQueue.isEmpty()) {
            sb.append(integerQueue.poll()).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
    }
}

class Album {
    int cnt = 0;
    int seq;

    public Album(int seq) {
        this.seq = seq;
    }
}