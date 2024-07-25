import java.io.*;
import java.util.*;

public class Main {
    // GPT: 비트연산자로 변환
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int howFarCanGo = 20 * 50;

        while (t-- > 0) {
            int conveniCnt = Integer.parseInt(br.readLine());

            Set<Integer> visited = new HashSet<>();
            int[] input;
            List<Point> pointList = new ArrayList<>();
            for (int i = 0; i < conveniCnt + 2; i++) {
                input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                pointList.add(new Point(input[0], input[1], i));
            }

            Stack<Point> stack = new Stack<>();
            stack.push(pointList.get(0));
            pointList.remove(0);

            boolean flag = false;
            while (!stack.isEmpty()) {
                Point point = stack.pop();
                if (point.index == conveniCnt + 1) {
                    flag = true;
                    break;
                } else {
                    for (int i = pointList.size() - 1; i >= 0; i--) {
                        Point newPoint = pointList.get(i);
                        if (Math.abs(newPoint.x - point.x) + Math.abs(newPoint.y - point.y) > howFarCanGo) {
                            continue;
                        } else {
                            stack.add(newPoint);
                            pointList.remove(i);
                        }
                    }
                }
            }
            if (flag) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    static class Point {
        int x, y, index;
        Set<Integer> canGo = new HashSet<>();

        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
}