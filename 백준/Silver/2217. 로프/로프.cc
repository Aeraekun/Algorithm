#include <cstdio>
#include <algorithm>

int main() {
	int n[100000], rope, best = 0;
	scanf("%d", &rope);
	for (int i = 0; i < rope; i++)
		scanf("%d", &n[i]);
	std::sort(&n[0],&n[rope-1]+1);
	for (int i = 0; i < rope; i++) {
		int temp = n[i] * (rope - i);
		if (best < temp) best = temp;
	}
	printf("%d\n", best);
    return 0;
}