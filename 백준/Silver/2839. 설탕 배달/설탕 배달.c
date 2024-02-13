#include <stdio.h>

int main() {
	int x, c5, c3;
	scanf("%d", &x);
	c5 = x / 5;
	for (int i = c5; i >= 0; i--) {
		if ((x - i * 5) % 3 == 0) {
			c3 = (x - i * 5) / 3;
			c5 = i;
			printf("%d", c3 + c5);
			return 0;
		}
	}
	printf("-1");
	return 0;
}
