#include <iostream>
#include <string.h>
#include <algorithm>
using namespace std;
const int MAX=10005 ;
const char dirName[][10]= {"L","Turning","R"};

struct Ant {
	int id;
	int position;
	// L:-1 Turning:0 R:1
	int dir;
} ;
Ant before[MAX],after[MAX];
int order[MAX];
bool cam(Ant a,Ant b) {
	return a.position < b.position;
}

int main() {
	int L , T , n , caseNum;
	int i,j,k,position,dir;
	char ch;
	cin>>caseNum;
	//case 
	for(k = 0 ; k < caseNum ; k++ ) {
		//input
		cin >> L >> T >> n;
		for(i = 0 ; i < n ; i++) {
			cin>>position;
			cin>>ch;
			dir = ch == 'L'?-1:1;
			
			before[i] = (Ant) {
				i,position,dir
			};
			
			after[i]  =(Ant) {
				i,position+T*dir,dir
			};
		}

		sort(before,before+n,cam);

		// mark down before id
		for(i = 0 ; i < n ; i++) {
			order[before[i].id] = i;
		}

		sort(after,after+n,cam);
		
		//set turning
		for(i = 0 ; i < n ; i++) {
			if(after[i].position == after[i+1].position) {
				after[i].dir = after[i+1].dir = 0;
			}
		}
		
		cout<<"Case #"<<k+1<<":"<<endl;
		for(i = 0; i < n ; i++) {
			int a = order[i];
			if(after[a].position < 0 || after[a].position > L){
				cout<<"Fell off"<<endl;
			}else{
				cout<<after[a].position<<" "<<dirName[after[a].dir+1]<<endl;
			}
		}
		cout<<"\n";
	}
	return 0;
}
