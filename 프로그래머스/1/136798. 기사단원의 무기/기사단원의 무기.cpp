#include <string>
#include <vector>
#include <iostream>
#include <cmath>
using namespace std;

int arr[100004];

int solution(int number, int limit, int power) {
    int answer = 0;
    
    // 기사 번호의 약수 개수에 해당하는 무기 구매 
    // 근데 limit보다 크거나 같으면 power가 공격력이 됨
    
    for(int i=1;i<=number;i++){
        
        int cnt=0;
        for(int j=1;j<=sqrt(i);j++){
            
            if(i%j==0){
                cnt++;
                if(j!=i/j){
                    cnt++;
                }
            }
            
            if(cnt>limit){
                break;
            }
        }
        
        if(cnt>limit){
            answer+=power;
        }else{
            answer+=cnt;
        }
        
        
    }
    
    
    return answer;
}