import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long cnt = 0;
    static int result = -1;
    static int[] A, tmp;
    static int N, K;

    public static void main(String[] args) throws IOException {
        // 병합 정렬 수행
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 배열의 크기
        K = Integer.parseInt(st.nextToken());   // 저장 횟수
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tmp = new int[N];

        mergeSort(0, N - 1);
        System.out.println(result);
    }

    static void mergeSort(int start, int end) {
        if (start < end) { // 종료 조건 수정
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    static void merge(int p, int q, int r) {
        int i = p, j = q + 1, t = 0; // t 초기값을 0으로 설정
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
            // 저장 횟수 체크
            cnt++;
            if (cnt == K) {
                result = tmp[t - 1];
            }
        }
        while (i <= q) {
            tmp[t++] = A[i++];
            cnt++;
            if (cnt == K) {
                result = tmp[t - 1];
            }
        }
        while (j <= r) {
            tmp[t++] = A[j++];
            cnt++;
            if (cnt == K) {
                result = tmp[t - 1];
            }
        }
        // tmp 배열의 정렬된 값을 A 배열에 복사
        for (i = p, t = 0; i <= r; i++, t++) {
            A[i] = tmp[t];
        }
    }
}
