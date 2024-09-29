#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
#include <iostream>
#include <stack>
using namespace std;

int solution(int n) {
    long long answer = 0;
    
    string str;
    
    vector<char>v;
    
    while(n){
        v.push_back((n%3)+'0');
        n/=3;
    }
    
    

    int cnt=0;
    for(int i=v.size()-1;i>=0;i--){

             answer+=pow(3,cnt)*(v[i]-'0');
                cnt++;
                if(i==0){
                    return answer;
                }   
            }
    
    
}