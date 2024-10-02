#include <string>
#include <vector>
#include <deque>
#include <iostream>
using namespace std;

int gcd(int a,int b){
    
    if(b==0){
        return a;
    }

    return gcd(b,a%b);
    
}

int solution(vector<int> arr) {
    int answer = 0;
    
    deque<int>dq;
    
    if(arr.size()==1){
        return arr[0];
    }
    
   for(int i=0;i<arr.size();i++){
       dq.push_back(arr[i]);
   }
    
    int a;
    int b;
    int num;
    while(1){
        
        
        
        a=dq.front();
        dq.pop_front();
        b=dq.front();
        dq.pop_front();
        num= gcd(a,b);
        
        dq.push_front(a*b/num);
        
        if(dq.size()==1){
            return dq.front();
        }
        
    }
    
}