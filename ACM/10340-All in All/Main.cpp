#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

int main() {
	string s , t;
	int i , j;
	while(cin>>s>>t) {
		string n;
		j = 0;
		for(i = 0 ; i < s.length() ; i++) {
			while(j < t.length()) {
				if(s[i] == t[j]) {
					n=n+t[j];
					j++;
					break;
				}
				j++;
			}
		}
		if(s.compare(n)==0) {
			printf("Yes\n");
		}else{
			printf("No\n");
		}
	}
	return 0;
}
