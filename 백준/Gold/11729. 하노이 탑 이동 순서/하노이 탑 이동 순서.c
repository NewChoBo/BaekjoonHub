#include<stdio.h>
#include<math.h>

void hanoi(int n, int start, int work, int target);


int main(void) {
	int N;
	int K;

	scanf("%d", &N);
	K = pow(2, N) - 1;

	printf("%d \n", K);

	hanoi(N, 1, 2, 3);
}

void hanoi(int n, int start, int work, int target) {
	if (n == 1) {
		printf("%d %d\n", start, target);
	}
	else {
		hanoi(n - 1, start, target, work);
		printf("%d %d\n", start, target);
		hanoi(n - 1, work, start, target);
	}
}