#include <cstdio>
#include <iostream>
using namespace std;

int main() {
	char str[51];
	int a[50];
	int b[50];
	int j = 0;
	int temp = 0;
	cin >> str;
	for (int i = 0; i < 50; i++) {
		if ('0' <= str[i] && str[i] <= '9')
			temp = temp * 10 + str[i] - '0';
		else if (str[i] == '+') {
			a[j] = temp;
			b[j] = 1;
			temp = 0;
			j++;
		}
		else if (str[i] == '-') {
			a[j] = temp;
			b[j] = 0;
			temp = 0;
			j++;
		}
	}
	a[j] = temp;

	for (int i = 0; i < j; i++) {
		if (b[i] == 0) {
			for (i; i < j; i++) {
				a[0] -= a[i + 1];
			}
			break;
		}
		a[0] += a[i + 1];
	}
	printf("%d\n", a[0]);
	return 0;
}