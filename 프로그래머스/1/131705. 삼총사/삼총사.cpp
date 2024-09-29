#include <string>
#include <vector>
#include <iostream>
using namespace std;

int cnt=0;

void combi(int start,vector<int>v,vector<int>number){
    
    if(v.size()==3){
        int sum=0;
        for(auto a:v){
    
            sum+=a;
        }
    
        if(sum==0)
            cnt++;
        return;
    }
    
    for(int i=start+1;i<number.size();i++){
        v.push_back(number[i]);
        combi(i,v,number);
        v.pop_back();
    }
    return;
}

int solution(vector<int> number) {
    int answer = 0;
    vector<int>v;
    combi(-1,v,number);
    
    return cnt;
}