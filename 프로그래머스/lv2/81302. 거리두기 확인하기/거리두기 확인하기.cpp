#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

char arr[6][6];

bool check_dist(int y,int x,int y2,int x2){
    
    if(x<x2){
           if(arr[y][x2-1]=='X')
               return true;
            if(arr[y][x+1]=='X'&&arr[y2][x2-1]=='X')
                return true;
    }
    else if(x>x2){
        if(arr[y][x-1]=='X')
            return true;
        if(arr[y][x-1]=='X'&&arr[y2][x2+1]=='X')
            return true;
    }
    else if(x==x2){
        if(y<y2){
            if(arr[y2-1][x]=='X')
                return true;
        }
        else if(y2<y){
            if(arr[y-1][x]=='X')
                return true;
        }
    }

    return false;
    
}

bool check(vector<pair<int,int>>v){
    
    for(int i=0;i<v.size();i++){
        for(int j=0;j<v.size();j++){
            if(i==j)
                continue;
            int cnt=abs(v[i].first-v[j].first)+abs(v[i].second-v[j].second);
            if(cnt<=2){
                if(check_dist(v[i].first,v[i].second,v[j].first,v[j].second)==false){
                    return false;
                }
            }
        }
    }
    
    return true;
    
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    
    for(int i=0;i<places.size();i++){

        vector<pair<int,int>>p;
        
        for(int j=0;j<places[i].size();j++){
            for(int k=0;k<places[i][j].size();k++){
                if(places[i][j][k]=='P'){
                    p.push_back({j,k});
                }
                arr[j][k]=places[i][j][k];
            }
        }
        
        
        if(check(p)==true)
            answer.push_back(1);
        else 
            answer.push_back(0);
        
        
    }
    
    
    
    
    // 파티션이있다 -> 배열에 1로 표시된 부분을 dfs돌렸을때 만난다 -> return 시킨다 
    
    // 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.
    
    

    
    
    return answer;
}