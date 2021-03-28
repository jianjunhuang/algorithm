#include <iostream>
#include <cstdio>

using namespace std;

int main(){
	int m , n , cut;
	while(scanf("%d%d",&m,&n) != EOF){
		cut = m*n -1;
		printf("%d\n",cut);
	}
	return 0;
}
