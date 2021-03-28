#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
using namespace std;

const int MAX = 10005;
double PI = acos(-1.0);
double pies[MAX];
int N,F;

double bsearch(double start , double end) {

	if(end - start <= 1e-4) {
		return end;
	}
	double mid = (start + end)/2;
	int sum = 0;
	for(int i = 0 ; i < N ; i++){
		sum += pies[i] / mid;
	}
	if(sum >= F){
		return bsearch(mid,end);
	}else{
		return bsearch(start,mid);
	}
}

int main() {
	int i;
	int caseNum;
	scanf("%d",&caseNum);
	while(caseNum--) {
		scanf("%d%d",&N,&F);
		F++;
		double sum = 0;
		for(i = 0 ; i < N ; i++) {
			scanf("%lf",&pies[i]);
			pies[i] = PI*pies[i]*pies[i];
			sum += pies[i];
		}
		double ans = bsearch(0,sum/F);
		printf("%.4lf\n",ans);
	}
	return 0;
}
