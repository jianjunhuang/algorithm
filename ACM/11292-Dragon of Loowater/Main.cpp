#include <iostream>
#include <algorithm>
using namespace std;
const int MAX = 20000+10;
int main() {
	int heads_diameters[MAX];
	int knights_heights[MAX];
	int knight_num,heads_num;
	int i,j,sum = 0;
	bool tag ;
	while(cin>>heads_num>>knight_num) {

		if(heads_num == 0 && knight_num == 0) {
			return 0;
		}

		//input the number of dragon's heads
		for(i = 0 ; i < heads_num ; i++) {
			cin>>heads_diameters[i];
		}
		//input the number of knight heights
		for(i = 0 ; i < knight_num ; i++) {
			cin>>knights_heights[i];
		}

		if(knight_num < heads_num) {
			cout<<"Loowater is doomed!\n";
			continue;
		}

		sort(heads_diameters,heads_diameters + heads_num);
		sort(knights_heights,knights_heights + knight_num);

		sum = 0;
		j = 0 ;
		tag = false;
		for(i = 0 ; i < heads_num ; i++) {

			while(j < knight_num) {
				if(knights_heights[j] >= heads_diameters[i]) {
					sum += knights_heights[j];
					j++;
					tag = true;
					break;
				} else {
					j++;
					tag =false;
				}
			}
			if( j == knight_num && i < heads_num - 1){
				tag = false;
				break;
			}
		}

		if(tag) {
			cout<<sum<<'\n';
		} else {
			cout<<"Loowater is doomed!\n";
		}
	}
	return 0;
}
