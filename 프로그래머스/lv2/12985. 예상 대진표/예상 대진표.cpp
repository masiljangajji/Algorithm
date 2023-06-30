#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int n, int a, int b)
{
    int answer = 0;
    
    int check=0;
    
    while(1){
        
        check++;
        
        
        int cnt=0;
        for(int i=1;i<=n;i+=2){
            cnt++;
            
            if(i==a&&b==i+1||i==b&&i+1==a)
                return check;
            
            if(i<=a&&a<=i+1)
                a=cnt;
            if(i<=b&&b<=i+1)
                b=cnt;
       }
        
        n/=2;
    }
    

    return answer;
}