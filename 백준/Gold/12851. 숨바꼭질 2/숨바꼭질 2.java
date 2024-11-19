import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int a;
  static int b;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    int max = Math.max(a, b) + 2;

    // 수빈이는 +1, -1, *2의 위치로 이동 가능
    Point[] map = new Point[max];
    for (int i = 0; i < map.length; i++) {
      map[i] = new Point();
    }
    Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> map[o].distance));
    map[a].distance = 0;
    map[a].cnt = 1;
    queue.add(a);

    solution(map, queue);
    System.out.println(map[b].distance);
    System.out.println(map[b].cnt);
  }

  static void solution(Point[] map, Queue<Integer> queue) {
    while (!queue.isEmpty()) {
      int current = queue.poll();
      Point point = map[current];
      int distance = point.distance;
      int[] mover = {current - 1, current + 1, current * 2};
      for (int move : mover) {
        if (move < 0 || move >= map.length) {
          continue;
        }
        Point next = map[move];
        if (next.distance > distance + 1) {
          next.distance = distance + 1;
          next.cnt = point.cnt;
          queue.add(move);
        } else if (next.distance == distance + 1) {
          next.cnt += point.cnt;
        }
      }
    }
  }

  static class Point {

    int cnt = 0;
    int distance = Integer.MAX_VALUE;

  }
}