#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    int cnt=1;
    while(cnt<=n){
        
        int sum=0;
    
        for(int i=cnt;i<=n;i++){
            sum+=i;
            if(sum>n)
                break;
            else if(sum==n){
                answer++;
                cout<<cnt<<"\n";
                break;
            }
        }
        cnt++;
    }
    
    return answer;
}