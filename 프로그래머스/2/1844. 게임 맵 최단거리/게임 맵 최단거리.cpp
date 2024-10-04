#include<vector>
#include<queue>
using namespace std;

int visit[104][104];
int dy[]={0,0,-1,1};
int dx[]={-1,1,0,0};

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    
    queue<pair<int,int>>q;
    
    q.push({0,0}); // 시작 지점
    visit[0][0]=1;
    
    int maxCol = maps.size();
    int maxRow = maps[0].size();
    
    while(q.size()){
        
        pair<int,int>p = q.front();
        q.pop();
        int y=p.first;
        int x=p.second;
        
        for(int i=0;i<4;i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            
            if(ny<0||nx<0||ny>=maxCol||nx>=maxRow){ // map범위 밖
                continue;
            }
            
            if(visit[ny][nx]){ // 방문했으면 
                continue;   
            }
            
            if(maps[ny][nx]==0){ // 벽이면 
                continue;
            }
            
            visit[ny][nx]=visit[y][x]+1;
            q.push({ny,nx});
        }
        
    }
    
    int ans= visit[maxCol-1][maxRow-1];
    
    if(ans==0){
        return -1;
    }
    
    return ans;
}