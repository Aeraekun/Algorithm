#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main(void)
{
	int n, m;
	int grass[100][100] = { 0 };
	char ans[100][4] = { NULL };
	int mini[101];
	int b = 1;
	int test_case;
	int T;
	setbuf(stdout, NULL);
	scanf("%d", &T);
	for (test_case = 0; test_case < T; test_case++)
	{
		scanf("%d %d", &n, &m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				scanf("%d", &grass[i][j]);
				if (mini[grass[i][j]] != 1) 
					mini[grass[i][j]] = 1;
			}
		}
		for (int min = 1; min < 101; min++) {
			if (b == 0)break;
			if (mini[min] == 0) continue;
			for (int i = 0; i < n; i++) {
				if (b == 0)break;
				for (int j = 0; j < m; j++) {
					if (b == 0)break;
					if (min == grass[i][j]) {
						for (int k = 0; k < n; k++) {
							if (min < grass[k][j]) {
								for (int l = 0; l < m; l++) {
									if (min < grass[i][l]) {
										ans[test_case][0] = 'N';
										ans[test_case][1] = 'O';
										b = 0;
										break;
									}
								}
							}
						}
					}
				}
			}
			
			
		}
		if (b == 1) {
			ans[test_case][0] = 'Y';
			ans[test_case][1] = 'E';
			ans[test_case][2] = 'S';
		}
		for (int i = 0; i < 101; i++) {
			mini[i] = 0;
		}
		b = 1;
	}
	for (int i = 0; i < T; i++) {
		printf("#%d %s\n", i + 1, ans[i]);
	}
	return 0;
}