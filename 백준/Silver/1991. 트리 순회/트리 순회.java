import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Map<Character, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        // 공통) 1. 일단 루트 노드를 구한다.
        Node rootNode = getRootNode(map.get('A'));
        StringBuilder sb = new StringBuilder();

        // 전위 순회
        preorderTraversal(rootNode, sb);
        sb.append('\n');

        // 중위 순회
        inorderTraversal(rootNode, sb);
        sb.append('\n');

        // 후위 순회
        postorderTraversal(rootNode, sb);
        sb.append('\n');

        System.out.print(sb);
    }

    static void preorderTraversal(Node node, StringBuilder sb) {
        sb.append(node.key);
        if (node.left != null) {
            preorderTraversal(node.left, sb);
        }
        if (node.right != null) {
            preorderTraversal(node.right, sb);
        }
    }

    static void inorderTraversal(Node node, StringBuilder sb) {
        if (node.left != null) {
            inorderTraversal(node.left, sb);
        }
        sb.append(node.key);
        if (node.right != null) {
            inorderTraversal(node.right, sb);
        }
    }

    static void postorderTraversal(Node node, StringBuilder sb) {
        if (node.left != null) {
            postorderTraversal(node.left, sb);
        }
        if (node.right != null) {
            postorderTraversal(node.right, sb);
        }
        sb.append(node.key);
    }

    static Node getRootNode(Node node) {
        while (node.parent != null) {
            node = node.parent;
        }
        return node;
    }

    static void init() throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char key = (char) ('A' + i);
            map.put(key, new Node(key));
        }
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            Node current = map.get(chars[0]);
            Node left = map.get(chars[2]);
            Node right = map.get(chars[4]);
            current.left = left;
            current.right = right;
            if (left != null) left.parent = current;
            if (right != null) right.parent = current;
        }
    }

    static class Node {
        char key;
        Node parent;
        Node left;
        Node right;

        Node(char key) {
            this.key = key;
        }
    }
}