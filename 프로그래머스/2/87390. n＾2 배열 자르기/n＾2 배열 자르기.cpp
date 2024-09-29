#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> v;
   
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
  
    
    int num;
    int num2;
    
    for(long long i=left;i<=right;i++){
  
        num=i/n+1; // 2 , 3 , 3, 3, 3, 4, 시작하는 숫자를 의미함
        num2=i%n; // 3 , 0 ,1 , 2 ,3 ,0 , 시작숫자랑 얼마나 멀리있나 
        
        if(num2+1>num){
            v.push_back(num2+1);
            continue;
        }else{
            v.push_back(num);   
            continue;
        }
        
    }
    return v;    
  
}