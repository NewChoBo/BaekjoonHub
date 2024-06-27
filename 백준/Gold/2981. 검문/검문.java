import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());    // N은 2 ~ 100
        int a = Integer.MAX_VALUE;

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < N; i++) {   // 1~ 10억
            // N개의 수 모두 M의로 나누었을 때의 나머지가 같다
            // M은 1보다 크다
            // M은 작은 수부터 출력한다
            // 일종의 최대공약수를 구하면 되는거 아닐까? 이건 아닌것같기도...
            integers.add(Integer.parseInt(br.readLine()));
        }

        // 소인수 분해라도 시켜야 하나?
        // 숫자 2개에 대해서 나머지가 같은 최대 수?
        // 최대공약수의 최대공약수의 최대공약수의 최대공약수의 최대공약수?


        // 모든 차 들의 최대공약수 일 것
        integers.sort(Comparator.naturalOrder());
        int gcdVal = Math.abs(integers.get(1) - integers.get(0));
        for (int i = 2; i < integers.size(); i++) {
            int newVal = integers.get(i) - integers.get(i - 1);
            gcdVal = getGcdVal(gcdVal, newVal);
        }

        // 모든 약수 수집
        int sqrt = (int) Math.sqrt(gcdVal); // 100의 제곱근은 10

        ArrayList<Integer> arr = new ArrayList<>(); // 약수 받을 ArrayList
        for (int i = 1; i <= sqrt; i++) {
            if (gcdVal % i == 0) { // 약수 중 작은 수 저장
                arr.add(i);
                if (gcdVal / i != i) { // 약수 중 큰 수 저장
                    arr.add(gcdVal / i);
                }
            }
        }
        arr.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.size(); i++) {
            sb.append(arr.get(i) + " ");
        }
        System.out.println(sb);
//        System.out.println(integers);
    }

    static int getGcdVal(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}