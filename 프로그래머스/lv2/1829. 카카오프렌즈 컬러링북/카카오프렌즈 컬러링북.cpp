#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

// 4방향으로 움직이겠다 .
int dy[]={0,0,-1,1};
int dx[]={-1,1,0,0};
bool visit[104][104];
int ylim,xlim;

int dfs(int y,int x,vector<vector<int>>v,int check){
    
    // 방문  check 
    visit[y][x]=1;
    
    int ret=1;
    
    for(int i=0;i<4;i++){
        
        int nx=x+dx[i];
        int ny=y+dy[i];
        
        // map 범위를 벗어난다면 pass 
        if(ny<0||nx<0||ny>=ylim||nx>=xlim)
            continue;
        // 이미 visit 했다면 pass 
        if(visit[ny][nx])
            continue;
        // 0이면 pass 
        if(v[ny][nx]==0)
            continue;
        // 다른면 pass 
        if(v[ny][nx]!=check)
            continue;
        
        ret+=dfs(ny,nx,v,check); 
    }
    
    return ret;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    
    
    fill(&visit[0][0],&visit[100][100],0);
    
    ylim=m;
    xlim=n;
    
    int cnt=0;
    int Max=0;
    
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(visit[i][j]==0&&picture[i][j]!=0){
                cnt++;
                int go=dfs(i,j,picture,picture[i][j]);
                Max=max(Max,go);
                cout<<cnt<<" "<<Max<<"\n";
            }
        }
    }
    
 vector<int>ans(2);
    ans[0]=cnt;
    ans[1]=Max;
    
    
    
    return ans;
}