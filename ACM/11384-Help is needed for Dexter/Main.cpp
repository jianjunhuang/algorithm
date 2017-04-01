#include <iostream>
#include <cstdio>
using namespace std;

int main(){
	int n,ans;
	while(scanf("%d",&n) != EOF){
		ans = 0;
		while(n){
			n /= 2;
			ans++;
		}
		printf("%d\n",ans);
	}
	return 0;
} 
