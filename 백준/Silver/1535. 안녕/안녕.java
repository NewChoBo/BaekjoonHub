import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1535
public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Person[] people = init(N);
		System.out.println(solve(people));
	}

	private static int solve(Person[] people) {
		int N = people.length;

		// 체력: 100, 기쁨: 0
		int startHealth = 100;
		int[] computed = new int[startHealth + 1];

		for (int i = 0; i < N; i++) {
			Person person = people[i];
			int loss = person.loss;
			int pleased = person.pleased;

			for (int j = (startHealth - 1) - loss; j >= 0; j--) {
				computed[j + loss] = Math.max(computed[j + loss], computed[j] + pleased);
			}
		}

		return computed[startHealth - 1];
	}

	private static Person[] init(int N) throws IOException {
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		Person[] people = new Person[N];
		for (int i = 0; i < N; i++) {
			int loss = Integer.parseInt(st1.nextToken());
			int pleased = Integer.parseInt(st2.nextToken());
			people[i] = new Person(loss, pleased);
		}
		return people;
	}

	private static class Person {
		int loss;
		int pleased;

		Person(int loss, int pleased) {
			this.loss = loss;
			this.pleased = pleased;
		}
	}
}