#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <algorithm>
using namespace std;

vector<int>v;

int solution(vector<int> v) {
    int answer = 0;
    
    sort(v.begin(),v.end());
    
    for(int i=v.size()-1;i>=0;i--){
        if(v.size()-i<=v[i]){
            answer=v.size()-i;
            
        }
    }
    
    
    return answer;

}