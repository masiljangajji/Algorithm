#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(int k, int m, vector<int> v) {
    int answer = 0;
    
    // k 점이 최상품 , 1점이 최하
    
    // 사과는 m개씩 담아 포장 , 가장 낮은점수가 P인경우 가격은 P*M;
    
    sort(v.begin(),v.end(),greater<int>());
    
    vector<int>n;
    int MIN=123456789;
    int cnt=0;
    for(auto a:v){
        
        MIN=min(MIN,a);
        cnt++;
        if(cnt==m){ // 상자 하나
            answer+=MIN*m;
            MIN=123456789;
            cnt=0;
        }
        
    }
    
    return answer;
}