import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/20056
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int T = input[0];
        int S = input[1];

        // 술과 같이 초밥 먹거나 점심식사 아닐 때는 밥알을 280개
        // 점심식사이면서 술과 같이 안먹으면 320개
        // 술 유무: S==1 -> 술, T가 11이하면 아침, 12~16이면 점심, 아니면 저녁
        if(T >= 12 && T <=16 && S==0) {
            System.out.println(320);
        } else {
            System.out.println(280);
        }
    }
}