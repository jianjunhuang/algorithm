#include <iostream>
#include <algorithm>
using namespace std;
const  int MAX = 10005;

struct bj{
	int j;
	int b;
}arr[MAX]; 

bool cam(bj var1,bj var2){
	return var1.j > var2.j;
}

int main(){
	int n,i,time,result,temp,case_num;
	case_num = 0;
	while(cin>>n){
		case_num++;
		if(n == 0){
			return 0;
		}
		for(i= 0 ; i < n ; i++){
			cin>>arr[i].b>>arr[i].j;
		}
		sort(arr,arr+n,cam);
		time = 0;
		result = 0;
		for(i = 0 ; i < n ; i++){
			time += arr[i].b;
			temp = time+arr[i].j;
			result = result>temp?result:temp;
		} 
		cout<<"Case "<<case_num<<": "<<result<<endl;
	}
	return 0;
}
