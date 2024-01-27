#include <stdio.h>
#include <math.h>

void jaegui(double, double, double, int);
int baeyeol[15];

int main() {
	double N, r, c;
	double ans = 0;
	scanf("%lf %lf %lf", &N, &r, &c);
	ans = pow(2, 2 * N);
	int count = (int)N;
	jaegui(N, r, c, count);
	for (int i = 0; i < N; i++) {
		ans -= (4 - baeyeol[i]) * pow(4, i);
	}
	ans -= 1;
	printf("%.0f", ans);
}

void jaegui(double N, double r, double c, int count) {
	if (N < 0);
	else if (pow(2, N) / 2 > r && pow(2, N) / 2 > c) {
		baeyeol[count-1] = 1;
		jaegui(N - 1, r, c, count-1);
	}
	else if (pow(2, N) / 2 <= r && pow(2, N) / 2 > c) {
		baeyeol[count-1] = 3;
		jaegui(N - 1, r - (pow(2, N) / 2), c, count-1);
	}
	else if (pow(2, N) / 2 > r && pow(2, N) / 2 <= c) {
		baeyeol[count-1] = 2;
		jaegui(N - 1, r, c - (pow(2, N) / 2), count-1);
	}
	else if (pow(2, N) / 2 <= r && pow(2, N) / 2 <= c) {
		baeyeol[count-1] = 4;
		jaegui(N - 1, r - (pow(2, N) / 2), c - (pow(2, N) / 2), count-1);
	}
}