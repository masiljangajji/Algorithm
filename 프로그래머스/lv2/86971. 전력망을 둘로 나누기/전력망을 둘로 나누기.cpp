#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int>v[104];
bool visit[104][104];

int dfs(int idx){
    
    int cnt=1;
    
    for(int i=0;i<v[idx].size();i++){
        
        if(visit[idx][v[idx][i]])   //||visit[v[idx][i]][idx])
            continue;
        
        visit[idx][v[idx][i]]=1;
        visit[v[idx][i]][idx]=1;
        
        cnt+=dfs(v[idx][i]);
    }
    
    return cnt;
    
}

int solution(int n, vector<vector<int>> wires) {
    
    int answer = 9999;
    
    
    for(int i=0;i<wires.size();i++){
        v[wires[i][0]].push_back(wires[i][1]);    
        v[wires[i][1]].push_back(wires[i][0]);  
    } 
    
    for(int i=1;i<=n;i++){
        
        int gogogo=v[i].size();
        for(int j=0;j<gogogo;j++){
            fill(&visit[0][0],&visit[103][103],0);
            
            int temp=v[i][j];
            int num=find(v[temp].begin(), v[temp].end(), i)-v[temp].begin();
            
            v[i].erase(v[i].begin()+j,v[i].begin()+1+j);
            v[temp].erase(v[temp].begin()+num,v[temp].begin()+1+num);
            
            int cnt=dfs(i);
            
            v[i].insert(v[i].begin()+j,temp);
            v[temp].insert(v[temp].begin()+num,i);
            
            int diff=n-cnt; // 전력2 
            
            //cout<<cnt<<" "<<diff <<" 이런\n";
            int ans =abs(diff-cnt); // 전력차이 
            
            answer=min(answer,ans);
            
        }
        
    }
    
    
    return answer;
}