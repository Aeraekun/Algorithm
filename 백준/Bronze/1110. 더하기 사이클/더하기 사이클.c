#include <stdio.h>

int main() {
	int count=1;
	int n;
	int tempt, tempo, temp;
	scanf("%d", &n);
	if (n < 10) {
		tempt = n;
		tempo = n;
	}
	else {
		tempt = n % 10;
		tempo = (n / 10 + tempt) % 10;
	}
	while (1) {
		if (n == tempt * 10 + tempo) break;
		if (tempt == 0) tempt = tempo;
		else {
			temp = tempt;
			tempt = tempo;
			tempo = (temp + tempo) % 10;
		}
		count++;
	}
	printf("%d", count);
}