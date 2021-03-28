#include<iostream>
#include<cstdio>
#include<algorithm>
#include<cstring>
using namespace std;

const int INF = 0x3f3f3f;
const int maxn = 20;
int n;
int mat[maxn][maxn];
int B[maxn][maxn];


int check(int s) {
	//初始化
	memset(B, 0, sizeof(B));
	for(int i=1; i<=n; ++i) {
		if(s & (1<<(i-1))) B[1][i]=1;
		else if(mat[1][i]) return INF;
	}
	for(int i=2; i<=n; ++i) {
		for(int j=1; j<=n; ++j) {
			int sum = B[i-2][j]+B[i-1][j-1]+B[i-1][j+1];
			B[i][j] = sum&1;
			if(mat[i][j] && B[i][j]==0) return INF;
		}
	}
	int cnt=0;
	for(int i=1; i<=n; ++i)
		for(int j=1; j<=n; ++j)
			if(mat[i][j] !=B[i][j]) ++cnt;
	return cnt;
}


int main() {

	int T;
	scanf("%d", &T);
	memset(mat, 0, sizeof(mat));

	for(int cas=1; cas<=T; ++cas) {
		//input grid size
		scanf("%d", &n);
		//input
		for(int i=1; i<=n; ++i)
			for(int j=1; j<=n; ++j)
				scanf("%d",&mat[i][j]);

		int ans = INF;
		//循环每个点
		for(int s=0; s<(1<<n); ++s)
			ans = min(ans, check(s));

		if(ans == INF)  ans=-1;
		printf("Case %d: %d\n", cas, ans);
	}
	return 0;
}
