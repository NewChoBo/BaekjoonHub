import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 1. 입력값 초기화
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        Node[] nodes = new Node[N + 1];
        for (int i = 0; i < N + 1; i++) nodes[i] = new Node();
        for (int i = 0; i < M; i++) {
            int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input2[0];
            int b = input2[1];
            Node nodeA = nodes[a];
            Node nodeB = nodes[b];
            nodeA.road.add(nodeB);
            nodeB.road.add(nodeA);
        }

        // 2. 모든 노드 순회하며 count 준비
        int cnt = -1;
        for (Node node : nodes) {
            if (!node.visited) {
                cnt++;
                setVisited(node);
            }
        }

        // 3. 출력
        System.out.println(cnt);   // 간선의 갯수가 0개인 경우를 고려하지 않아 틀렸음
    }

    static void setVisited(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node linkedNode : currentNode.road) {
                if (!linkedNode.visited) {
                    queue.add(linkedNode);
                    linkedNode.visited = true;
                }
            }
        }
    }

    static class Node {
        boolean visited = false;
        List<Node> road = new ArrayList<>();
    }
}
