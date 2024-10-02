#include <string>
#include <vector>
#include <deque>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    
    deque<string>dq;
    
    if(cacheSize==0){
        return cities.size()*5;
    }
    
    for(auto a:cities){
        
        transform(a.begin(), a.end(), a.begin(), ::toupper);
        
        if(dq.empty()){
            dq.push_front(a);
            answer+=5;
            continue;
        }
        
        auto it = find(dq.begin(),dq.end(),a);
        
        if(it==dq.end()){ // 캐시 미스
            
            if(dq.size()==cacheSize){ // 꽉 차면 비워야함 
                dq.pop_back();
                dq.push_front(a);
            }else{ // 꽉 안참
                dq.push_front(a);
            }
            answer+=5;
        }else{ // 캐시 히트 
            dq.erase(it);
            dq.push_front(a);
            answer+=1;
        }
        
        
    }
    
    return answer;
}