#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;

const int MAX = 15;

char grid[MAX][MAX];
int main() {
	int num,kase,T;
	int i,j;
	scanf("%d",&T);
	kase = 0;
	while(T--) {
		scanf("%d",&num);
		for(i = 0 ; i < num ; i++) {
			scanf("%s",grid[i]);
		}
		for(i = 0 ; i < num ; i++){
			for(j = 0 ; j < num ; j++){
				if(grid[i][j] == '.'){
					for(char ch = 'A' ; ch <= 'Z' ; ch++){
						bool tag = true;
						if(i > 0 && grid[i-1][j] == ch){
							tag = false;
						}
						if(i < num-1 && grid[i+1][j] == ch){
							tag = false;
						}
						if(j > 0 && grid[i][j-1] == ch){
							tag = false;
						}
						if(j < num-1 && grid[i][j+1] == ch){
							tag = false;
						}
						if(tag){
							grid[i][j] = ch;
							break;
						}
					}
				} 
			}
		}
		printf("Case %d:\n",++kase);
		for(i = 0 ; i < num ; i++){
			printf("%s\n",grid[i]);
		}
	}
	return 0;
}
