#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    
    // 회원은 금액지불하면 10일 , 회원 대상으로 제품 하나 할인 , 할인 제품은 하루에 하나만 
    // 원하는 제품과 수량이 할인 날짜와 10일 연속 일치하면 회원가입
    
    for(int i=0;i<=discount.size()-10;i++){
        map<string,int>m;
        
        // apple 3 ,banana 2, rice 1 , pot 1 , 
        
        for(int j=i;j<i+10;j++){
            m[discount[j]]++;
        }
        int sum=0;
        bool check=true;
        for(int p=0;p<want.size();p++){
            if(m[want[p]]!=number[p]){
                check=false;
                break;
            }
        }
        if(check){
            answer++;
        }
            
    }
    
    
    return answer;
}