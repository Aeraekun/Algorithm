#include <cstdio>
#define MAX 41
int result[MAX];
int c0[MAX];
int c1[MAX];

int main()
{
	int count;
	c0[0] = 1;
	c1[1] = 1;
	for (int i = 2; i < MAX; i++)
	{
		c0[i] = c0[i - 1] + c0[i - 2];
		c1[i] = c1[i - 1] + c1[i - 2];
	}
	scanf("%d", &count);
	for (int i = 0; i < count; i++) scanf("%d", &result[i]);
	for (int i = 0; i < count; i++)
		printf("%d %d\n", c0[result[i]], c1[result[i]]);
}

