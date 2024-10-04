#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

int ans;
bool visited[104][104];
vector<int>v[104];

int bf(int idx){
    
    int cnt=1;
    
    for(int i=0;i<v[idx].size();i++){
        
        if(visited[idx][v[idx][i]])
            continue;
        
        visited[idx][v[idx][i]]=1;
        visited[v[idx][i]][idx]=1;
        
        cnt+=bf(v[idx][i]);
        
    }
    
    return cnt;
    
}

int solution(int n, vector<vector<int>> wires) {
    int answer = -1;
    
    
    for(int i=0;i<wires.size();i++){
        v[wires[i][0]].push_back(wires[i][1]);
        v[wires[i][1]].push_back(wires[i][0]);
    }
 
    
    int ans=9999;
    for(int i=1;i<=n;i++){
        int size = v[i].size();
        
        for(int j=0;j<size;j++){
            fill(&visited[0][0],&visited[0][0]+103*103,0);
            
            int temp=v[i][j]; // 숫자 
            
            int num=find(v[temp].begin(),v[temp].end(),i)-v[temp].begin();
            
            v[i].erase(v[i].begin()+j,v[i].begin()+1+j);  // 한칸 지우기 
            v[temp].erase(v[temp].begin()+num,v[temp].begin()+1+num); // 역으로도 한칸 지우기
            
            int cnt=bf(i);
            
            v[i].insert(v[i].begin()+j,temp);
            v[temp].insert(v[temp].begin()+num,i);
                
            int diff=n-cnt;
            ans=min(ans,abs(diff-cnt));
        }
        
    }
    
    return ans;
}