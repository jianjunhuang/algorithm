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
˫�������жϣ�ֱ�������Ҫ����Ŀ��ֱ��������Ҫ����Ŀ��ȥ��ǰ����Ŀ�������ǰ��Ŀ������Ҫ�ľ�ֱ�Ӽ�һ
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
