#include <cstdio>
#define Max 6

int main() {
	int price, count = 0;
	int coin[Max] = { 500,100,50,10,5,1 };
	scanf("%d", &price);
	price = 1000 - price;
	for (int i = 0; i <= Max-1; i++) {
		if (price / coin[i] != 0) {
			count += price / coin[i];
			price %= coin[i];
		}
	}
	printf("%d\n", count);
}