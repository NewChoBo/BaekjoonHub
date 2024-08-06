import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String S, T;

    // https://www.acmicpc.net/problem/12919
    // charAt과 indexOf를 구분하지 못하여 헤맴
    public static void main(String[] args) throws IOException {
        S = br.readLine();
        T = br.readLine();

        // 동작 1: 문자열 뒤에 A 추가
        // 동작 2: 문자열 뒤에 B 추가 후 reverse
        // 글자 수 차이만큼 동작
        // S를 T로 만들 수 있는가?

        /**
         * 판정안
         * 1. S 또는 S의 reverse 문자열이 T 안에 들어가 있는가?
         * 2. T에서 S로 변환하는 것을 시도한다.
         *  - 글자 줄일 수 있는가 여부 
         *      a. 문자열 끝이 A이면 A 제거
         *      b. 문자열 시작이 B이면 B 제거 후 reverse 
         */
        /**
         * 일단 S문자열이 T 안에 존재하는지 확인해야 함
         */
        String text = T;
        boolean result = recursive(text);
        if(result)
            System.out.println(1);
        else
            System.out.println(0);
    }

    static boolean recursive(String text) {
        if (text.equals(S)) return true;
        if (text.length() <= S.length()) return false;
        if (text.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(text.substring(1)).reverse();
            if (recursive(sb.toString())) return true;
        }
        if (text.charAt(text.length() - 1) == 'A') {
            if (recursive(text.substring(0, text.length() - 1))) return true;
        }
        return false;
    }
}