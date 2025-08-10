#include <stdio.h>

int m[100];
int now;
int main() {
	int N, M;
	scanf("%d", &N);
	scanf("%d", &M);
	for (int i = 0; i < N; i++) scanf("%d", &m[i]);
	for (int i = 0; i < N; i++) {
		for (int j = 1; j < N; j++) {
			if (m[j] == m[i])continue;
			for (int k = 2; k < N; k++) {
				if (m[k] == m[i] || m[k] == m[j])continue;
				if (m[i] + m[j] + m[k] == M) {
					printf("%d", M);
					return 0;
				}
				if (m[i] + m[j] + m[k] > M) continue;
				if (m[i] + m[j] + m[k] > now) now = m[i] + m[j] + m[k];
			}
		}
	}
	printf("%d", now);
	return 0;
}