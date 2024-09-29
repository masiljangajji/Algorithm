#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    
    long long num=n;
    
    int cnt=0;
    
    while(num!=1){
        
        if(cnt==500){
            return -1;
        }
        
        if(num%2==0){
            num/=2;
        }else{
            num=num*3+1;
        }
        
        cnt++;
    }
    
    return cnt;
}