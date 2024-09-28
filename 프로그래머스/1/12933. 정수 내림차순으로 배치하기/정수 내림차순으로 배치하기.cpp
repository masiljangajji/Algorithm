#include <string>
#include <vector>
#include<iostream>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    vector<int>v;
    
    while(n>0){
        v.push_back(n%10);
        n/=10;

        cout<<n<<" ";
    }
    
    
    
    return answer;
}