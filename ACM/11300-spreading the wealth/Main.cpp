#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
const int MAX = 1000005;
long long n[MAX],c[MAX];
int main() {
	long long avg = 0LL,mid,ans = 0LL;
	int i,num;
	while (cin>>num,num > 0) {
		avg = 0LL;
		for(i = 0 ; i < num ; i++) {
			cin>>n[i];
			avg += n[i];
		}
		avg = avg/num;
		c[0] = 0;
		for(i = 1 ; i < num ; i++) {
			c[i] = c[i-1] + (avg - n[i]);
		}
		sort(c,c+num);
		mid = c[num/2];
		ans = 0LL;
		for (i = 0 ; i < num ; i++) {
			ans += abs(mid - c[i]);
		}
		cout<<ans<<endl;
	}
	return 0;
}
