#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

vector<int> solution(int k, vector<int> score) {
    vector<int> answer;
    
    priority_queue<int,vector<int>,greater<int>>pq;
    
    for(auto a:score){
        if(pq.size()<k){
            pq.push(a);
            answer.push_back(pq.top());
        }else{
            if(pq.top()<a){
                pq.pop();
                pq.push(a);
            }
            answer.push_back(pq.top());
        }
    }
    
    
    return answer;
}