#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
using namespace std;

const int Max = 500005;

int main(){
	int floor[Max],size;
	int kase;
	int i,j,border,ans;
	bool tag;
	scanf("%d",&kase);
	while(kase--){
		scanf("%d",&size);
		for(i = 0 ; i < size ; i++){
			scanf("%d",&floor[i]);
		}
		sort(floor,floor+size);
		ans = 1;
		i = 0;
		j = size-1;
		//tag == true 下一层是蓝色 
		if(abs(floor[i]) > floor[j]){
			tag = false;
			i++;
		}else{
			tag = true;
			j--;
		}
		while(true){
			if(tag){
				if(floor[i] < 0 && abs(floor[i]) < floor[j+1]){
					tag = false;
					i++;
					ans++;
				}else if(floor[i] < 0){
					i++;
					continue;
				}else{
					break;
				}	
			} else {
				if(floor[j] > 0 && abs(floor[i-1]) > floor[j]){
					tag = true;
					j--;
					ans++;
				}else if(floor[j] > 0){
					j--;
					continue;
				}else{
					break;
				}
			}
		}
		printf("%d\n",ans);
	}
	return 0;
}
