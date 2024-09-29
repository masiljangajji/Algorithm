#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(int a,int b){
    return a>b;
}

long long solution(long long n) {
    long long answer = 0;
    
    vector<int>v;
    
    while(n){
        v.push_back(n%10);
        n/=10;
    }
    
    sort(v.begin(),v.end(),cmp);
    
    for(int i=0;i<v.size()-1;i++){
        answer+=v[i];
        answer*=10;
    }
    answer+=v[v.size()-1];
    
    return answer;
}