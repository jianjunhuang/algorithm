#include <iostream>
#include <cstdio>
int N , ans;
int get(int n) {
	int t = n*2;
	if(N == 1){
		return 0;
	}
	if(t < N) {
		ans++;
		return get(t);
	}
	if(t >= N) {
		ans++;
		return 0;
	}
}
/*
双倍复制判断，直到多出需要的数目，直接用所需要的数目减去当前的数目，如果当前数目大于需要的就直接加一
*/
int main() {
	int kase = 1;
	while(true) {
		scanf("%d",&N);
		if(N <= 0 || N > 10000 ) {
			break;
		}
		ans = 0;
		get(1);
		printf("Case %d: %d\n",kase++,ans);
	}
	return 0;
}
