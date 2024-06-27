import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = 0;
        int maxIndex = 0;
        int sum = 0;
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                maxIndex = i;
                max = arr[i];
                sum += tempSum;
                tempSum = 0;
            } else {
                if (max - arr[i] > 0) {
                    tempSum += max - arr[i];
                }
            }
//            System.out.println("현 위치 : " + arr[i] + ", 현재 합: " + sum + ", 임시 합: " + tempSum);
        }

//        System.out.println("-----------------------------");

        max = 0;
        tempSum = 0;
        for (int i = arr.length - 1; maxIndex <= i; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                sum += tempSum;
                tempSum = 0;
            } else {
                if (max - arr[i] > 0) {
                    tempSum += max - arr[i];
                }
            }
//            System.out.println("현 위치 : " + arr[i] + ", 현재 합: " + sum + ", 임시 합: " + tempSum);
        }

        System.out.println(sum);
    }
}