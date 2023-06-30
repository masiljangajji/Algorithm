#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;

int visit[100][100];
bool check;

void dfs(int y,int x,vector<string>board){
    
    if(board[y][x]=='0') // board 가 0인경우 pass = 이미 지워진 빈 칸인 경우 
        return;
    
    if(board[y][x]==board[y+1][x]&&board[y][x]==board[y][x+1]&&board[y][x]==board[y+1][x+1]){ // 2 x 2 배치된 4개 블록이 같다면 
        check=false;
        visit[y][x]=visit[y+1][x]=visit[y+1][x+1]=visit[y][x+1]=1; // 1로 처리해준다
    }
    return;    
}

int solution(int m, int n, vector<string> board) {
    int answer = 0;
    
    while(1){
        check=true;
        fill(&visit[0][0],&visit[99][99],0); // visit 배열 초기화 
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(board[i][j]!='0'){ // 빈칸이 아닌 경우에 같은 블록인지 확인하겠다
                    dfs(i,j,board);  
                }
         }
        }
        
        for(int i=0;i<n;i++){
            vector<pair<int,int>>v;
            for(int j=0;j<m;j++){ 
                if(visit[j][i]!=1&&board[j][i]!='0') // board에 값 있고 안 사라지는 경우
                    v.push_back({j,i}); // vector에 추가
            }
            
           for(int k=m-1;k>=0;k--){ 
                if(v.size()){ // vector에 사이즈 있는만큼 board에 맨 아래서부터 넣는다
                    pair<int,int>a=v.back();
                    board[k][i]=board[a.first][a.second];
                    v.pop_back();
                }
                else
                    board[k][i]='0'; // 그 외는 전부 0처리
            }
        }
        
        
    
        if(check==true)// 지워지는게 하나도 없으면 break 
            break;
    
    }
    
    for(int i=0;i<board.size();i++){
            for(auto a:board[i]){
                if(a=='0') // 총 지워진 개수 = 0의 개수 
                    answer++;
            }
    }
    
    
    return answer;
}