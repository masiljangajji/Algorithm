#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, vector<vector<int>> dungeons) {

    vector<int>v;
    
    for(int i=0;i<dungeons.size();i++){
        v.push_back(i);
    }
    
    int Max=0;
    
    do {
        int cnt=0;
        int now=k;
		for (auto a : v) {
			if(dungeons[a][0]>now){
                break;
            }
            else{
                cnt++;
                now-=dungeons[a][1];
            }
		}
		
        if(Max<cnt)
            Max=cnt;
        
	} while (next_permutation(v.begin(), v.end()));
    
    
    return Max;
}