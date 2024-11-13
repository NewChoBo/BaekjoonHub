import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());    // 64 이하
        char[][] map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        recursive(map, 0, 0, N);
        System.out.print(sb);
    }

    static void recursive(char[][] map, int x, int y, int size) {
        boolean allSame = checkAllSame(map, x, y, size);
        if (allSame) {
            sb.append(map[x][y]);
            return;
        }
        sb.append('(');
        size /= 2;
        recursive(map, x, y, size);
        recursive(map, x, y + size, size);
        recursive(map, x + size, y, size);
        recursive(map, x + size, y + size, size);
        sb.append(')');
    }

    static boolean checkAllSame(char[][] map, int x, int y, int size) {
        char defalutChar = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != defalutChar) {
                    return false;
                }
            }
        }
        return true;
    }
}