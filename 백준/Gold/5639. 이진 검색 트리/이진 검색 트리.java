import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		BinaryNode rootNode = new BinaryNode(Integer.parseInt(br.readLine()));
		String line;
		while ((line = br.readLine()) != null && !"".equals(line)) {
			BinaryNode currentNode = new BinaryNode(Integer.parseInt(line));
			rootNode.setNode(currentNode);
		}

		// 후위 순회 (Post-order Traversal) - Iterative 방식으로 구현
		Stack<BinaryNode> stack = new Stack<>();
		Stack<BinaryNode> resultStack = new Stack<>();
		stack.push(rootNode);

		while (!stack.isEmpty()) {
			BinaryNode node = stack.pop();
			resultStack.push(node);

			// 후위 순회를 위해, 먼저 왼쪽 자식 노드를 스택에 삽입
			if (node.prev != null) {
				stack.push(node.prev);
			}
			// 그리고 오른쪽 자식 노드를 스택에 삽입
			if (node.after != null) {
				stack.push(node.after);
			}
		}

		// 결과를 출력하기 위해, 결과 스택을 사용
		StringBuilder sb = new StringBuilder();
		while (!resultStack.isEmpty()) {
			sb.append(resultStack.pop().value).append('\n');
		}
		System.out.print(sb);
	}

	static class BinaryNode {
		int value;
		BinaryNode prev, after;

		BinaryNode(int value) {
			this.value = value;
		}

		void setNode(BinaryNode currentNode) {
			if (this.value > currentNode.value) {
				if (this.prev == null) {
					this.prev = currentNode;
				} else {
					this.prev.setNode(currentNode);
				}
			} else {
				if (this.after == null) {
					this.after = currentNode;
				} else {
					this.after.setNode(currentNode);
				}
			}
		}
	}
}
