#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int res;
int sum;
int answer;

void ps(int depth,vector<int>numbers,vector<int>v){
    
    if(depth==numbers.size()){
        
        int sum=0;
        for(auto a:v){
            sum+=a;
        }
        
        if(sum==res){
            answer++;
        }
        return;
    }
    
        for(int j=0;j<2;j++){
            if(j==0){
                v[depth]=numbers[depth];
                ps(depth+1,numbers,v);
            }
            else{
                v[depth]=numbers[depth]*-1;
                ps(depth+1,numbers,v);
         }
        }
     return;       
}

int solution(vector<int> numbers, int target) {
    
    ios_base::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);
    
    res=target;
    
    vector<int>v(numbers.size());
    
    ps(0,numbers,v);

    
  
    return answer;
}