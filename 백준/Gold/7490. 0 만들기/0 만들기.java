import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		// 아스키 코드 순서: ' ', '+', '-'
		// 0이면 ' '
		// 1이면 '+'
		// 2이면 '-'
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n - 1];
			boolean flag = true;

			int value = 0;
			while (flag) {
				String expression = "";
				for (int i = 1; i <= n; i++) {
					expression += i;
					if (i != n) {
						if (arr[n - i - 1] == 0) {
							expression += " ";
						} else if (arr[n - i - 1] == 1) {
							expression += "+";
						} else if (arr[n - i - 1] == 2) {
							expression += "-";
						}
					}
				}
				int result = evaluateExpression(expression);
				if (result == 0) {
					bw.write(expression + "\n");
				}
				flag = plusOne(arr);
			}
			bw.write("\n");
		}
		bw.flush();
	}

	static boolean plusOne(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 2) {
				arr[i]++;
				return true;
			} else {
				arr[i] = 0;
			}
		}
		return false;
	}

	static int evaluateExpression(String expression) {
		int sum = 0;
		String newExpression = expression.replace(" ", "");
		int[] numbers = Arrays.stream(newExpression.split(("\\+|\\-"))).mapToInt(Integer::parseInt).toArray();
		Queue<Character> operators = new ArrayDeque<>();
		operators.add('+');
		for (char character : newExpression.toCharArray()) {
			if (character == '+' || character == '-') {
				operators.add(character);
			}
		}

		for (int number : numbers) {
			char operator = operators.poll();
			switch (operator) {
				case '+':
					sum += number;
					break;
				case '-':
					sum -= number;
					break;
			}
		}

		return sum;
	}
}
